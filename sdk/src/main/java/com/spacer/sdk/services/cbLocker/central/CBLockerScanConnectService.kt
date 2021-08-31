package com.spacer.sdk.services.cbLocker.central

import android.content.Context
import com.spacer.sdk.data.ICallback
import com.spacer.sdk.data.IResultCallback
import com.spacer.sdk.data.SPRError
import com.spacer.sdk.models.cbLocker.CBLockerModel
import com.spacer.sdk.services.cbLocker.peripheral.CBLockerGattPutService
import com.spacer.sdk.services.cbLocker.peripheral.CBLockerGattTakeService

class CBLockerScanConnectService : CBLockerScanService() {
    private lateinit var spacerId: String
    private lateinit var callback: IResultCallback<CBLockerModel>

    private fun scan(context: Context, spacerId: String, callback: IResultCallback<CBLockerModel>) {
        this.spacerId = spacerId
        this.callback = callback

        val scanCallback = CBLockerScanConnectCallback()
        super.startScan(context, scanCallback)
    }

    fun put(context: Context, spacerId: String, callback: ICallback) {
        scan(
            context,
            spacerId,
            object : IResultCallback<CBLockerModel> {
                override fun onSuccess(result: CBLockerModel) = CBLockerGattPutService().connect(context, result, callback)
                override fun onFailure(error: SPRError) = callback.onFailure(error)
            }
        )
    }

    fun take(token: String, context: Context, spacerId: String, callback: ICallback) {
        scan(
            context,
            spacerId,
            object : IResultCallback<CBLockerModel> {
                override fun onSuccess(result: CBLockerModel) = CBLockerGattTakeService().connect(token, context, result, callback)
                override fun onFailure(error: SPRError) = callback.onFailure(error)
            }
        )
    }

    private inner class CBLockerScanConnectCallback : CBLockerScanCallback() {
        override fun onDiscovered(cbLocker: CBLockerModel) {
            if (cbLocker.spacerId == spacerId) {
                stopScan()
                callback.onSuccess(cbLocker)
            }
        }

        override fun onDelayed(): Boolean = true
    }
}