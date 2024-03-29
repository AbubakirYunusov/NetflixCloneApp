package com.example.data.models

import com.google.gson.annotations.SerializedName

data class MovieGenreCloudModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
)
