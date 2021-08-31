package com.spacer.sdk.services.cbLocker.peripheral

import android.bluetooth.*
import android.content.Context
import com.spacer.sdk.data.ICallback
import com.spacer.sdk.data.IMapper
import com.spacer.sdk.data.IResultCallback
import com.spacer.sdk.data.SPRError
import com.spacer.sdk.data.api.api
import com.spacer.sdk.data.api.reqData.key.KeyGenerateReqData
import com.spacer.sdk.data.api.reqData.key.KeyGenerateResultReqData
import com.spacer.sdk.data.api.resData.key.KeyGenerateResData
import com.spacer.sdk.data.extensions.RetrofitCallExtensions.enqueue
import com.spacer.sdk.models.cbLocker.CBLockerModel

class CBLockerGattPutService : CBLockerGattService() {
    private lateinit var callback: ICallback

    fun connect(context: Context, cbLocker: CBLockerModel, callback: ICallback) {
        this.callback = callback

        val gattCallback = CBLockerGattPutCallback()
        super.connect(context, cbLocker, gattCallback, needsFirstRead = true)
    }

    private open inner class CBLockerGattPutCallback : CBLockerGattCallback() {
        override fun onKeyGetting(characteristic: BluetoothGattCharacteristic, cbLocker: CBLockerModel, callback: IResultCallback<String>) {
            val params = KeyGenerateReqData(spacerId, characteristic.readData())
            val mapper = object : IMapper<KeyGenerateResData, String> {
                override fun map(source: KeyGenerateResData) = source.key ?: ""
            }
            api.key.generate(params).enqueue(callback, mapper)
        }

        override fun onFinished(characteristic: BluetoothGattCharacteristic, cbLocker: CBLockerModel, callback: ICallback) {
            val params = KeyGenerateResultReqData(spacerId, characteristic.readData())
            api.key.generateResult(params).enqueue(callback)
        }

        override fun onSuccess() = callback.onSuccess()
        override fun onFailure(error: SPRError) = callback.onFailure(error)
    }
}

