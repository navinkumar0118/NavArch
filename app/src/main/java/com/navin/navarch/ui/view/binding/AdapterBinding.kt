package com.navin.navarch.ui.view.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.navin.navarch.data.model.Pokemon
import com.navin.navarch.ui.home.adapter.PokemonListAdapter


@BindingAdapter("pokemonList")
fun pokemonList(recyclerView: RecyclerView, list: ArrayList<Pokemon>?) {
    val adapter = recyclerView.adapter as PokemonListAdapter
    adapter.submitList(list)

}