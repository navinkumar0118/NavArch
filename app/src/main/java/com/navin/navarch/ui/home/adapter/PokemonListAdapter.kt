package com.navin.navarch.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.navin.navarch.data.model.Pokemon
import com.navin.navarch.databinding.CellPokemonListBinding


class  PokemonListAdapter(callBack: CallBack) :
    ListAdapter<Pokemon, PokemonListAdapter.SearchViewHolder>(DiffCallback) {

    private var mListener: CallBack = callBack

    class SearchViewHolder(
        private var binding: CellPokemonListBinding,
        listener: CallBack
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Pokemon) {
            binding.pokemon = data
            binding.executePendingBindings()
        }

        init {
            binding.parentLayout.setOnClickListener {
                binding.pokemon?.let { data ->
                    listener.onCardClick(data)
                }
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.pokemonName == newItem.pokemonName
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.url == newItem.url
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder {
        return SearchViewHolder(
            CellPokemonListBinding.inflate(LayoutInflater.from(parent.context)),
            mListener
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val myTeamsDetail = getItem(position)
        holder.bind(myTeamsDetail)
    }

    interface CallBack {
        fun onCardClick(tournamentRound: Pokemon)
    }
}
