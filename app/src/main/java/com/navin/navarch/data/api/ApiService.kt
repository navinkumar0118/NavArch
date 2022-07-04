package com.navin.navarch.data.api

import android.content.Context
import com.navin.navarch.base.PrivateSharedPrefManager
import com.navin.navarch.common.Constants.Companion.BASE_URL
import com.navin.navarch.data.api.model.GetPokemonListResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("pokemon")
    suspend fun getPokemonList(): Response<GetPokemonListResponse>


    /** ------------------------------------------------------------------------------------- */

    companion object {

        fun create(context : Context): ApiService {

            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(OAuthInterceptor(PrivateSharedPrefManager(context)))
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}
