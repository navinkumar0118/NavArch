package com.navin.navarch.di

import android.content.Context
import com.navin.navarch.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideApiService(@ApplicationContext context: Context): ApiService {
        return ApiService.create(context)
    }
}
