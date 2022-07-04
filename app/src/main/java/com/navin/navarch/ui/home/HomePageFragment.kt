package com.navin.navarch.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.navin.navarch.base.BaseFragment
import com.navin.navarch.data.model.Pokemon
import com.navin.navarch.databinding.FragmentHomePageBinding
import com.navin.navarch.ui.home.adapter.PokemonListAdapter
import kotlinx.coroutines.launch
import com.navin.navarch.data.Result
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomePageFragment : BaseFragment<FragmentHomePageBinding>(), PokemonListAdapter.CallBack {

    private lateinit  var _binding: FragmentHomePageBinding
    private val binding get() = _binding
    private val sharedViewModel: HomePageViewModel by activityViewModels() //shared viewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
        }
        binding.roundsRecyclerView.adapter = PokemonListAdapter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseUI()
        getPokemonData()
        initialiseObservers()
    }

    private fun initialiseUI(){

        binding.toolbar.setNavigationOnClickListener {
            activity?.finish()
        }
    }


    private fun getPokemonData(){
        /** Service call */
        lifecycleScope.launch {
            sharedViewModel.getPokemonServiceCall()
        }
    }

    private fun initialiseObservers(){
        sharedViewModel.getPokemonResponse.observe(viewLifecycleOwner) { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    showLoadingDialog(false)
                    result.data?.let {
                            sharedViewModel.setPokemonList(result.data.pokemonList)
                    }
                }
                Result.Status.LOADING -> {
                    showLoadingDialog(true)
                }
                Result.Status.ERROR -> {
                    showLoadingDialog(false)
                }
            }
        }
    }

    override fun onCardClick(tournamentRound: Pokemon) {
        //on pokemon pressed, callback
    }
}