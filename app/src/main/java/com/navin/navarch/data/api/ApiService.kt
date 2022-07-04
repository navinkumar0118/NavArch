package com.navin.navarch.data.api

import android.content.Context
import com.navin.navarch.base.PrivateSharedPrefManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface ApiService {


    /** ------------------------------------------------------------------------------------- */

    companion object {
        private const val BASE_URL = "https://sportsal.com/app/api/v1/"

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
