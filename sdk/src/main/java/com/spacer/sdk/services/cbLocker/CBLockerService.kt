package com.spacer.sdk.services.cbLocker

import android.content.Context
import com.spacer.sdk.data.ICallback
import com.spacer.sdk.data.IResultCallback
import com.spacer.sdk.data.SPRError
import com.spacer.sdk.data.api.api
import com.spacer.sdk.data.api.reqData.myLocker.MyLockerReserveCancelReqData
import com.spacer.sdk.data.api.reqData.myLocker.MyLockerReserveReqData
import com.spacer.sdk.data.api.reqData.myLocker.MyLockerShareUrlKeyReqData
import com.spacer.sdk.data.extensions.RetrofitCallExtensions.enqueue
import com.spacer.sdk.models.cbLocker.CBLockerModel
import com.spacer.sdk.models.myLocker.*
import com.spacer.sdk.models.sprLocker.SPRLockerModel
import com.spacer.sdk.services.cbLocker.central.CBLockerScanConnectService
import com.spacer.sdk.services.cbLocker.central.CBLockerScanListService
import com.spacer.sdk.services.cbLocker.central.CBLockerScanService
import com.spacer.sdk.services.myLocker.MyLockerService

class CBLockerService {
    fun scan(token: String, context: Context, callback: IResultCallback<List<SPRLockerModel>>) {
        CBLockerScanListService().scan(token, context, callback)
    }

    fun put(token: String, context: Context, spacerId: String, callback: ICallback) {
        CBLockerScanConnectService().put(token, context, spacerId, callback)
    }

    fun take(token: String, context: Context, spacerId: String, callback: ICallback) {
        CBLockerScanConnectService().take(token, context, spacerId, callback)
    }

    fun takeWithUrlKey(token: String, context: Context, urlKey: String, callback: ICallback) {
        MyLockerService().shareUrlKey(
            token,
            urlKey,
            object : IResultCallback<MyLockerModel> {
                override fun onSuccess(result: MyLockerModel) = take(token, context, result.id, callback)
                override fun onFailure(error: SPRError) = callback.onFailure(error)
            })

    }
}