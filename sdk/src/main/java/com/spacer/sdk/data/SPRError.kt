package com.spacer.sdk.data

import java.io.Serializable

data class SPRError(
    val code: String,
    val message: String
) : Serializable {

    override fun toString() = "${code},$${message}"

    companion object {

        /**
         * API (E22002001 〜 E22002100)
         */
        val ApiFailed = SPRError("E22002001", "api request failed")
        val ApiBodyFailed = SPRError("E22002011", "api request failed")

        /**
         * CB Scan  (E22010001 〜 E22011000)
         */
        val CBScanDisabled = SPRError("E22010001", "bluetooth is disabled")
        val CBScanDeviceNotFound = SPRError("E22010001", "bluetooth device is not found")
        val CBScanFailed = SPRError("E22010001", "bluetooth is powered off")

        val CBResetting = SPRError("E21010002", "bluetooth is resetting")
        val CBUnauthorized = SPRError("E21010003", "bluetooth is unauthorized")
        val CBUnknown = SPRError("E21010004", "bluetooth is unknown")
        val CBUnsupported = SPRError("E21010005", "bluetooth is unsupported")

        val CBCentralTimeout = SPRError("E21010101", "central timed out")
        val CBConnectingFailed = SPRError("E21010102", "central connecting failed")

        /**
         * CB Peripheral(E21011001 〜 E21012000)
         */
        val CBDiscoveringServicesFailed = SPRError("E22011001", "peripheral discovering services failed")
        val CBDiscoveringCharacteristicsFailed = SPRError("E22011002", "peripheral discovering characteristics failed")
        val CBReadingCharacteristicFailed = SPRError("E21011003", "peripheral reading characteristic failed")
        val CBWritingCharacteristicFailed = SPRError("E21011004", "peripheral writing characteristic failed")
        val CBPeripheralNotFound = SPRError("E21011101", "peripheral is not found")
    }
}
