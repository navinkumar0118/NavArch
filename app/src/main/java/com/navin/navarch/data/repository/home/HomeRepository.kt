package com.navin.navarch.data.repository.home
import com.navin.navarch.data.api.ApiService
import com.navin.navarch.data.api.BaseRemoteDataSource
import com.navin.navarch.data.api.model.GetPokemonListResponse
import javax.inject.Inject
import javax.inject.Singleton
import com.navin.navarch.data.Result


@Singleton
class HomeRepository @Inject constructor(private val service: ApiService) : BaseRemoteDataSource() {

    suspend fun getPokemonDataFromService(): Result<GetPokemonListResponse> {
        return getResult { service.getPokemonList() }
    }
}