package com.spacer.sdk.values.cbLocker

import com.spacer.sdk.SPR
import java.util.*

class CBLockerConst {
    companion object {
        private const val BLE_RW_SUCCESS_STATE  = "rwsuccess"
        private const val BLE_W_SUCCESS_STATE  = "wsuccess"
        private const val BLE_USING_STATE  = "using"

        const val BLE_PUTIN_WRITE = "543214723567xxxrw"
        const val BLE_TAKEOUT_WRITE = "543214723567xxxw"
        val ScanMills = SPR.config.scanMills

        val BleCanNotPutinStateList  = arrayOf(BLE_RW_SUCCESS_STATE, BLE_W_SUCCESS_STATE, BLE_USING_STATE)
        val ServiceUUID = UUID.fromString("0000ff10-0000-1000-8000-00805f9b34fb")!!
        val CharacteristicUUID = UUID.fromString("0000ff11-0000-1000-8000-00805f9b34fb")!!

    }
}