package com.spacer.sdk.values.cbLocker

import com.spacer.sdk.SPR
import java.util.*

class CBLockerConst {
    companion object {
        private const val DEVICE_RW_SUCCESS_STATE  = "rwsuccess"
        private const val DEVICE_W_SUCCESS_STATE  = "wsuccess"
        private const val DEVICE_USING_STATE  = "using"

        const val DEVICE_PUT_PREFIXE = "543214723567xxxrw"
        const val DEVICE_TAKE_PREFIXE = "543214723567xxxw"

        val ScanMills = SPR.config.scanMills

        val DeviceCanNotPutinStateList  = arrayOf(DEVICE_RW_SUCCESS_STATE, DEVICE_W_SUCCESS_STATE, DEVICE_USING_STATE)
        val DeviceServiceUUID = UUID.fromString("0000ff10-0000-1000-8000-00805f9b34fb")!!
        val DeviceCharacteristicUUID = UUID.fromString("0000ff11-0000-1000-8000-00805f9b34fb")!!

    }
}