package com.fueled.data.entities.user

/**
 * Created by Mohd Irfan on 23/1/22.
 */
data class AddressSchema(
        val street: String,
        val suite: String,
        val city: String,
        val zipcode: String,
        val geo: GeoSchema
) {

    inner class GeoSchema(val geo: String?, val lng: String?)
}