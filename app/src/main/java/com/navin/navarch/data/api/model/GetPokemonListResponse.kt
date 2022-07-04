package com.navin.navarch.data.api.model

import com.google.gson.annotations.SerializedName
import com.navin.navarch.data.model.Pokemon

class GetPokemonListResponse(
    @SerializedName("count")
    var count: Int? = null,

    @SerializedName("results")
    var pokemonList: ArrayList<Pokemon> = ArrayList(),

    @SerializedName("next")
    var nextUrl: String? = null
)
