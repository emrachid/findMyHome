package com.redspace.findmyhome

import java.io.Serializable

data class Property(
    val id: Long,
    val title: String,
    val address: String,
    val bedrooms: Int,
    val bathrooms: Int,
    val postDate: Long,
    val priceInCad: Int,
    val summary: String,
    val description: String,
    val imageId: Int = 0,
    val parking: Boolean,
    val petFriendly: Boolean,
    val agreementType: String,
    val moveInDate: Long,
    val size: Int,
    val furnished: Boolean,
    val smokePermitted: Boolean,
    val accessibility: Boolean,
) : Serializable
