package com.spacer.sdk.data.api

import com.spacer.sdk.data.api.reqData.key.KeyGenerateReqData
import com.spacer.sdk.data.api.reqData.key.KeyGenerateResultReqData
import com.spacer.sdk.data.api.reqData.key.KeyGetReqData
import com.spacer.sdk.data.api.reqData.key.KeyGetResultReqData
import com.spacer.sdk.data.api.resData.key.KeyGenerateResData
import com.spacer.sdk.data.api.resData.key.KeyGenerateResultResData
import com.spacer.sdk.data.api.resData.key.KeyGetResData
import com.spacer.sdk.data.api.resData.key.KeyGetResultResData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface IKeyAPI {
    @POST("exApp/key/generate")
    fun generate(@Body params: KeyGenerateReqData): Call<KeyGenerateResData>

    @POST("exApp/key/generateResult")
    fun generateResult(@Body params: KeyGenerateResultReqData): Call<KeyGenerateResultResData>

    @POST("exApp/key/get")
    fun get(@Body params: KeyGetReqData): Call<KeyGetResData>

    @POST("exApp/key/getResult")
    fun getResult(@Body params: KeyGetResultReqData): Call<KeyGetResultResData>
}
