package com.spacer.sdk.data.extensions

import android.util.Log
import com.spacer.sdk.data.*

import com.spacer.sdk.data.api.resData.IResData
import com.spacer.sdk.data.extensions.ErrorResDataExtensions.toSPRError
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LoggerExtensions {
    inline val <reified T> T.TAG: String get() = T::class.java.simpleName

    inline fun <reified T> T.logd(msg: String) = Log.d(TAG, msg)
    inline fun <reified T> T.logd(msg: String, tr: Throwable?) = Log.d(TAG, msg, tr)
    inline fun <reified T> T.logw(msg: String) = Log.w(TAG, msg)
    inline fun <reified T> T.loge(msg: String) = Log.e(TAG, msg)
    inline fun <reified T> T.loge(msg: String, tr: Throwable?) = Log.e(TAG, msg, tr)
}