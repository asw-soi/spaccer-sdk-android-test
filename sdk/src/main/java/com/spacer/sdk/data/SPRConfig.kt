package com.spacer.sdk.data

class SPRConfig {
    constructor(
        baseURL: String = SPRConst.BaseURL,
        scanSeconds: Double = SPRConst.ScanSeconds
    )

    companion object {
        val Default = SPRConfig()
    }
}