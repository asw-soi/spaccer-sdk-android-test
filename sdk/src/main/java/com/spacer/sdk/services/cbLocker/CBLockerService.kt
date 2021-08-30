package com.spacer.sdk.services.cbLocker

import com.spacer.sdk.data.ICallback
import com.spacer.sdk.data.IResultCallback
import com.spacer.sdk.data.api.api
import com.spacer.sdk.data.api.reqData.myLocker.MyLockerReserveCancelReqData
import com.spacer.sdk.data.api.reqData.myLocker.MyLockerReserveReqData
import com.spacer.sdk.data.api.reqData.myLocker.MyLockerShareUrlKeyReqData
import com.spacer.sdk.data.extensions.RetrofitCallExtensions.enqueue
import com.spacer.sdk.models.myLocker.*
import com.spacer.sdk.models.sprLocker.SPRLockerModel

class CBLockerService {
    fun scan(token: String, callback: IResultCallback<List<SPRLockerModel>?>) {
    }

    fun put(token: String, spacerId: String, callback: ICallback) {
    }

    fun take(token: String, spacerId: String, callback: ICallback) {
    }

    fun takeByUrlKey(token: String, urlKey: String, callback: ICallback) {
    }
}