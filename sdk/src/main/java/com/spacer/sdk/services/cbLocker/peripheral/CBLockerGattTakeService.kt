package com.spacer.sdk.services.cbLocker.peripheral

import android.bluetooth.BluetoothGattCharacteristic
import android.content.Context
import com.spacer.sdk.data.ICallback
import com.spacer.sdk.data.IMapper
import com.spacer.sdk.data.IResultCallback
import com.spacer.sdk.data.SPRError
import com.spacer.sdk.data.api.api
import com.spacer.sdk.data.api.reqData.key.KeyGetReqData
import com.spacer.sdk.data.api.reqData.key.KeyGetResultReqData
import com.spacer.sdk.data.api.resData.key.KeyGetResData
import com.spacer.sdk.data.extensions.RetrofitCallExtensions.enqueue
import com.spacer.sdk.models.cbLocker.CBLockerModel

class CBLockerGattTakeService : CBLockerGattService() {
    private lateinit var token: String
    private lateinit var callback: ICallback

    fun connect(token: String, context: Context, cbLocker: CBLockerModel, callback: ICallback) {
        this.token = token
        this.callback = callback

        val gattCallback = CBLockerGattTakeCallback()
        super.connect(context, cbLocker, gattCallback, needsFirstRead = false)
    }

    private open inner class CBLockerGattTakeCallback : CBLockerGattCallback() {
        override fun onKeyGetting(characteristic: BluetoothGattCharacteristic, cbLocker: CBLockerModel, callback: IResultCallback<String>) {
            val params = KeyGetReqData(spacerId)
            val mapper = object : IMapper<KeyGetResData, String> {
                override fun map(source: KeyGetResData) = source.key ?: ""
            }
            api.key.get(params).enqueue(callback, mapper)
        }

        override fun onFinished(characteristic: BluetoothGattCharacteristic, cbLocker: CBLockerModel, callback: ICallback) {
            val params = KeyGetResultReqData(spacerId, characteristic.readData())
            api.key.getResult(params).enqueue(callback)
        }

        override fun onSuccess() = callback.onSuccess()
        override fun onFailure(error: SPRError) = callback.onFailure(error)
    }
}

