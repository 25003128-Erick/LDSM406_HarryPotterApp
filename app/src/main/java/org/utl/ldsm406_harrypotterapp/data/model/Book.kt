package org.utl.ldsm406_harrypotterapp.data.model

import com.google.gson.annotations.SerializedName

data class Book(
    val id: String? = null,
    val title: String? = null,
    val author: String? = null,
    val release_date: String? = null,
    val pages: Int? = null,
    @SerializedName("cover")
    val cover: String? = null,
    val summary: String? = null
)