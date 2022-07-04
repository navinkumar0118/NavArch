package com.navin.navarch.data.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("name") var pokemonName: String? = null,
    @SerializedName("url") var url: String? = null,
)
