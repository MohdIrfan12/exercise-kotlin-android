package com.fueled.data.entities.post

/**
 * Created by Mohd Irfan on 23/1/22.
 */
data class CommentsSchema (
        val postId:Int,
        val id:Int,
        val email:String,
        val name:String,
        val body:String
)