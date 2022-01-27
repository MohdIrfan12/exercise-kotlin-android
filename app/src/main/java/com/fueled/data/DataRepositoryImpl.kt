package com.fueled.data

import com.fueled.data.entities.post.CommentsSchema
import com.fueled.data.entities.post.PostSchema
import com.fueled.data.entities.user.UserSchema
import com.fueled.data.util.FileReader
import com.fueled.data.util.Parser
import com.fueled.ui.User

/**
 * Created by Mohd Irfan on 23/1/22.
 */
class DataRepositoryImpl(private val fileReader: FileReader) : DataRepository {

    override fun getUsers(count: Int): List<UserSchema> {
        val totalUsers: List<UserSchema> = Parser.parseJson(fileReader.getUsers())
        val totalPosts: List<PostSchema> = Parser.parseJson(fileReader.getPosts())
        val totalComments: List<CommentsSchema> = Parser.parseJson(fileReader.getComments())
        val users = filterUsers(totalUsers, totalPosts, totalComments)
        if (users.size <= count) {
            return users
        } else {
            return users.sortedByDescending { it.commentsAvg }.take(count);
        }
    }

    private fun filterUsers(
        totalUsers: List<UserSchema>,
        totalPosts: List<PostSchema>,
        totalComments: List<CommentsSchema>
    ): List<UserSchema> {
        val posts: List<PostSchema> = appendCommentsWithPosts(totalPosts, totalComments)
        return appendPostWithUsers(totalUsers, posts)
    }

    private fun appendCommentsWithPosts(
        totalPosts: List<PostSchema>,
        totalComments: List<CommentsSchema>
    ): List<PostSchema> {
        totalPosts.forEach { post ->
            post.totalComments = totalComments.filter { it.postId == post.id }.size
        }
        return totalPosts
    }

    private fun appendPostWithUsers(
        totalUsers: List<UserSchema>,
        posts: List<PostSchema>
    ): List<UserSchema> {
        totalUsers.forEach { user ->
            user.totalPosts = posts.filter { postSchema ->
                val result = postSchema.userId == user.id
                if (result) {
                    user.totalComments = user.totalComments + postSchema.totalComments
                }
                result
            }.size.toDouble()
            user.commentsAvg = (user.totalComments / user.totalPosts)
        }
        return totalUsers
    }


}