package com.navin.navarch.ui.home
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.navin.navarch.base.PrivateSharedPrefManager
import com.navin.navarch.data.api.model.GetPokemonListResponse
import com.navin.navarch.data.model.Pokemon
import com.navin.navarch.data.repository.home.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.navin.navarch.data.Result


@HiltViewModel
class HomePageViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {

    @Inject
    lateinit var privateSharedPreferencesManager: PrivateSharedPrefManager

    private val _pokemonList = MutableLiveData<ArrayList<Pokemon>>()
    val pokemonList: LiveData<ArrayList<Pokemon>> = _pokemonList

    private val _getPokemonResponse = MutableLiveData<Result<GetPokemonListResponse>>()
    val getPokemonResponse: LiveData<Result<GetPokemonListResponse>> = _getPokemonResponse

    init {
        _pokemonList.value = ArrayList()
    }

    suspend fun getPokemonServiceCall() {
            _pokemonList.postValue(ArrayList())
            _getPokemonResponse.postValue(Result.loading(null))
            val res = homeRepository.getPokemonDataFromService()
            _getPokemonResponse.postValue(res)
    }

    fun setPokemonList(pokemonList: ArrayList<Pokemon>) {
        _pokemonList.value = pokemonList
    }

}