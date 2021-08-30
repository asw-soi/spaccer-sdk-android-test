package com.spacer.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.spacer.sdk.SPR
import com.spacer.sdk.data.IResultCallback
import com.spacer.sdk.models.myLocker.MyLockerModel
import com.spacer.sdk.models.sprLocker.SPRLockerModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSPRLockers()
        getMyLockers()
    }

    private fun getSPRLockers(){
        val callback = object : IResultCallback<List<SPRLockerModel>?> {
            override fun onSuccess(result: List<SPRLockerModel>?) {
                val aa = result
            }
        }

        val aa = SPR.sprLockerService().getLockers("", listOf("SPACER055"), callback)
    }

    private fun getMyLockers(){
        val callback = object : IResultCallback<List<MyLockerModel>?> {
            override fun onSuccess(result: List<MyLockerModel>?) {
                val aa = result
            }
        }

        val aa = SPR.myLockerService().get("", callback)
    }
}