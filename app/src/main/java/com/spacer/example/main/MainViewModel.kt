package com.spacer.example.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.spacer.sdk.SPR
import com.spacer.sdk.data.IResultCallback
import com.spacer.sdk.data.SPRConfig
import com.spacer.sdk.data.extensions.LoggerExtensions.TAG
import com.spacer.sdk.models.myLocker.MyLockerModel
import com.spacer.sdk.models.sprLocker.SPRLockerModel
import androidx.navigation.findNavController
import com.spacer.example.R
import com.spacer.example.common.ProgressBarViewModel

class MainViewModel : ViewModel() {
    val tabVisible = MutableLiveData<Boolean>()
    var progressBar = ProgressBarViewModel()

    init {
        tabVisible.value = true
        progressBar.isOverlay.value = false
    }
}
