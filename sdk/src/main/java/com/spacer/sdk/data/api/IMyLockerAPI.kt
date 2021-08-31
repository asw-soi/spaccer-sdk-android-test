package com.spacer.sdk.data.api

import com.spacer.sdk.data.api.reqData.myLocker.MyLockerReserveCancelReqData
import com.spacer.sdk.data.api.reqData.myLocker.MyLockerReserveReqData
import com.spacer.sdk.data.api.reqData.myLocker.MyLockerShareUrlKeyReqData
import com.spacer.sdk.data.api.resData.myLocker.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface IMyLockerAPI {
    @POST("myLocker/get")
    fun get(): Call<MyLockerGetResData>

    @POST("myLocker/reserve")
    fun reserve(@Body params: MyLockerReserveReqData): Call<MyLockerReserveResData>

    @POST("myLocker/reserveCancel")
    fun reserveCancel(@Body params: MyLockerReserveCancelReqData): Call<MyLockerReserveCancelResData>

    @POST("myLocker/shared")
    fun shareUrlKey(@Body params: MyLockerShareUrlKeyReqData): Call<MyLockerShareUrlKeyResData>
}
