package com.fueled.data.entities.user

import com.fueled.data.entities.post.PostSchema

/**
 * Created by Mohd Irfan on 23/1/22.
 */
data class UserSchema(
    val id: Int,
    val name: String,
    val username: String,
    val address: AddressSchema,
    val phone: String,
    val website: String,
    val company: CompanySchema,
) {
    var totalPosts: Double = 0.0;
    var totalComments: Double = 0.0;
    var commentsAvg: Double = 0.0;
}