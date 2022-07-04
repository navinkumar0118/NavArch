package com.navin.navarch.data.repository.home
import com.navin.navarch.data.api.ApiService
import com.navin.navarch.data.api.BaseRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(private val service: ApiService) : BaseRemoteDataSource() {
//    suspend fun callLogin() : Result<BaseResponse> {
//        return getResult { service.test() }
//    }
//
//    suspend fun updateFCM(request: UpdateFCMRequest) : Result<BaseResponse> {
//        return getResult { service.updateFCM(request) }
//    }
//
//    /** notification */
//    suspend fun getAllNotificationsData(): Result<NotificationResponse> {
//        return getResult { service.getAllNotifications() }
//    }
//
//    suspend fun getHomeData(): Result<HomeResponse> {
//        return getResult { service.getHomeData() }
//    }
}