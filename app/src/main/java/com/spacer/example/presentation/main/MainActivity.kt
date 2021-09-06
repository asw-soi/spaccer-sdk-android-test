package com.spacer.example.presentation.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.spacer.sdk.SPR
import com.spacer.sdk.data.SPRConfig
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.spacer.example.R
import com.spacer.example.databinding.ActivityMainBinding
import com.spacer.example.presentation.common.PermissionRequester
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    private lateinit var navController: NavController
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataBinding()
        initNavController()

        PermissionRequester(this).run()

        configure()
//        getSPRLockers()
//        getMyLockers()
    }

    private fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun initNavController() {
        navController = findNavController(R.id.container)
        bottom_navigation.setupWithNavController(navController)
    }
    

    private val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcGlLZXlJZCI6InA0Tmwwa1NhY1hWbnRlbUhnWk1hSFpyMXAyMlhSVExmaDNtYjd5TSIsInVzZXJJZCI6Ii1NX2NWNzY0Q2RwaUVCdTVQRW40IiwiaWF0IjoxNjMwMzgwMDcyLCJleHAiOjE2MzE1ODk2NzJ9.gq9I0xOCswnvLpCqTNyCrd03ukbFWyawiDOFjGkNYUA"

    private fun configure(){

        val config = SPRConfig(baseURL = "http://120.143.1.101:8008/exApp")
//        val config = SPRConfig(baseURL = "https://api-vsv0ukl18tz6dm.spacer.co.jp")
        SPR.configure(config)
    }

    fun startLoading(option: LoadingOption) {
        val isOverlay = option == LoadingOption.Overlay
        val isNotTouchable = option == LoadingOption.Overlay || option == LoadingOption.ScreenLock

        viewModel.progressBar.enable(isOverlay)
        if (isNotTouchable) {
            window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }
    }

    fun stopLoading() {
        viewModel.progressBar.disable()
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }
}


enum class LoadingOption {
    Overlay,
    ScreenLock,
    NotScreenLock,
}