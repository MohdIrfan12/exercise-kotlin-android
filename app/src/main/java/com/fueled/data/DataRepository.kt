package com.fueled.data

import com.fueled.data.entities.user.UserSchema
import com.fueled.ui.User


/**
 * Created by Mohd Irfan on 23/1/22.
 */
interface DataRepository {
    fun getUsers(count: Int): List<UserSchema>
}