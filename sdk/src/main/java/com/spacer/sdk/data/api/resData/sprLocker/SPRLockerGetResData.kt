package com.spacer.sdk.data.api.resData.sprLocker

import com.spacer.sdk.data.api.resData.ErrorResData
import com.spacer.sdk.data.api.resData.IResData
import java.io.Serializable

data class SPRLockerGetResData(
    val spacers: List<SPRLockerResData>?,
    override val result: Boolean,
    override val error: ErrorResData?,
) : IResData

