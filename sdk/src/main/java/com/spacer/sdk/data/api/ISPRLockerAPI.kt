package com.spacer.sdk.data.api

import com.spacer.sdk.data.api.reqData.sprLocker.SPRLockerGetReqData
import com.spacer.sdk.data.api.reqData.sprLocker.SPRLockerUnitGetReqData
import com.spacer.sdk.data.api.resData.sprLocker.SPRLockerGetResData
import com.spacer.sdk.data.api.resData.sprLocker.SPRLockerUnitGetResData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ISPRLockerAPI {
    @POST("exApp/locker/spacer/get")
    fun getLockers(@Body params: SPRLockerGetReqData): Call<SPRLockerGetResData>

    @POST("exApp/locker/unit/get")
    fun getUnits(@Body params: SPRLockerUnitGetReqData): Call<SPRLockerUnitGetResData>
}
