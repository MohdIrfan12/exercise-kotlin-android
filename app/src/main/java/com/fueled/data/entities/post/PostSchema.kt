package com.fueled.data.entities.post

/**
 * Created by Mohd Irfan on 23/1/22.
 */
data class PostSchema (
        val userId:Int,
        val id:Int,
        val title:String,
        val body:String
)
{
        var totalComments =  0;
}