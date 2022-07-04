package com.navin.navarch.di

import android.content.Context
import com.navin.navarch.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

//    @Provides
//    fun provideADao(appDatabase: AppDatabase): PlantDao {
//        return appDatabase.A_Dao()
//    }
//    @Provides
//    fun provideGardenBDao(appDatabase: AppDatabase): GardenPlantingDao {
//        return appDatabase.B_Dao()
//    }
//
}
