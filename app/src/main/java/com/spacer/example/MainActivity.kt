package com.spacer.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.spacer.sdk.SPR
import com.spacer.sdk.data.IResultCallback
import com.spacer.sdk.data.SPRConfig
import com.spacer.sdk.data.extensions.LoggerExtensions.TAG
import com.spacer.sdk.models.myLocker.MyLockerModel
import com.spacer.sdk.models.sprLocker.SPRLockerModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configure()
        getSPRLockers()
        getMyLockers()
    }

    private val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcGlLZXlJZCI6InA0Tmwwa1NhY1hWbnRlbUhnWk1hSFpyMXAyMlhSVExmaDNtYjd5TSIsInVzZXJJZCI6Ii1NX2NWNzY0Q2RwaUVCdTVQRW40IiwiaWF0IjoxNjMwMzgwMDcyLCJleHAiOjE2MzE1ODk2NzJ9.gq9I0xOCswnvLpCqTNyCrd03ukbFWyawiDOFjGkNYUA"

    private fun configure(){

        val config = SPRConfig(baseURL = "http://120.143.1.101:8008/exApp")
//        val config = SPRConfig(baseURL = "https://api-vsv0ukl18tz6dm.spacer.co.jp")
        SPR.configure(config)
    }

    private fun getSPRLockers(){
        val callback = object : IResultCallback<List<SPRLockerModel>> {
            override fun onSuccess(result: List<SPRLockerModel>) {
                Log.d(TAG, result.joinToString("\n"))
            }
        }

        val aa = SPR.sprLockerService().getLockers(token, listOf("SPACER055"), callback)
    }

    private fun getMyLockers(){
        val callback = object : IResultCallback<List<MyLockerModel>> {
            override fun onSuccess(result: List<MyLockerModel>) {
                Log.d(TAG, result.joinToString("\n"))
            }
        }

        val aa = SPR.myLockerService().get(token, callback)
    }
}