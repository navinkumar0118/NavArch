package com.navin.navarch.data.repository.launcher
import com.navin.navarch.data.api.ApiService
import com.navin.navarch.data.api.BaseRemoteDataSource
import com.navin.navarch.ui.launcher.LauncherViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LauncherRepository @Inject constructor(private val service: ApiService) : BaseRemoteDataSource() {

    suspend fun checkNavigationFlow() : LauncherViewModel.NavigationState{
        return LauncherViewModel.NavigationState.HOME_PAGE
    }

}