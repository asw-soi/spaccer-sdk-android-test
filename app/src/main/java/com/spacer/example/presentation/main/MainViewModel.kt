package com.spacer.example.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spacer.example.presentation.common.progress.ProgressBarViewModel

class MainViewModel : ViewModel() {
    val tabVisible = MutableLiveData<Boolean>()
    var progressBar = ProgressBarViewModel()

    init {
        tabVisible.value = true
        progressBar.isOverlay.value = false
    }
}
