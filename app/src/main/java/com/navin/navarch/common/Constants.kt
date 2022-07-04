package com.navin.navarch.common

import androidx.annotation.IntDef

class Constants {

    companion object {

        @IntDef(
            REQUEST_NONE,
            REQUEST_RUNNING,
            REQUEST_SUCCEEDED,
            REQUEST_FAILED
        )
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        annotation class RequestState

        const val ACCESS_TOKEN = "TOKEN"

        const val REQUEST_NONE = 0
        const val REQUEST_RUNNING = 1
        const val REQUEST_SUCCEEDED = 2
        const val REQUEST_FAILED = 3
        const val SERVICE_OK_STATUS = "ok"
        const val SERVICE_ERROR_STATUS = "error"

        const val BASE_URL = "https://apps.t10.me/bhandhan/api/v1/"

        const val DATABASE_NAME = "navArchDB"


    }

}