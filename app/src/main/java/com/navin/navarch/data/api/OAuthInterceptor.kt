package com.navin.navarch.data.api

import com.navin.navarch.base.PrivateSharedPrefManager
import com.navin.navarch.common.Constants.Companion.ACCESS_TOKEN
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OAuthInterceptor @Inject constructor(private val privateSharedPrefManager: PrivateSharedPrefManager) : Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = privateSharedPrefManager.getStringFromSharedPreferences(ACCESS_TOKEN)
        var request = chain.request()
        request =
            request.newBuilder().header("Authorization", "Bearer $token").build()
        return chain.proceed(request)    }

}

