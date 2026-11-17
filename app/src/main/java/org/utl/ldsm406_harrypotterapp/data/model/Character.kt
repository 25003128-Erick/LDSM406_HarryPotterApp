package org.utl.ldsm406_harrypotterapp.data.model

import com.google.gson.annotations.SerializedName

data class Character(
    val id: String? = null,
    val name: String? = null,
    val house: String? = null,
    val species: String? = null,
    val patronus: String? = null,
    @SerializedName("image")
    val image: String? = null
)