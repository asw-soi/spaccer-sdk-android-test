package com.spacer.example.presentation.myLocker

import androidx.fragment.app.Fragment
import com.spacer.example.BuildConfig
import com.spacer.example.presentation.common.SDKExecutor
import com.spacer.example.presentation.common.card.CardViewListener
import com.spacer.example.presentation.common.dialog.DialogMessage
import com.spacer.sdk.SPR
import com.spacer.sdk.models.myLocker.MyLockerModel
import com.spacer.sdk.models.sprLocker.SPRLockerModel


class MyLockerListener(private val fragment: Fragment) {

    private val service = SPR.myLockerService()
    private val executor = SDKExecutor(fragment)

    val get = object : CardViewListener.ISimpleCardViewListener {
        override fun onClicked() {
            executor.runList<MyLockerModel>(DialogMessage.MyLockerGetSuccess) {
                service.get(BuildConfig.SPR_TOKEN, it)
            }
        }
    }

    val reserve = object : CardViewListener.IInputCardViewListener {
        override fun onClicked(text: String) {
            executor.runGet<MyLockerModel>(DialogMessage.MyLockerReserveSuccess) {
                service.reserve(BuildConfig.SPR_TOKEN, text, it)
            }
        }
    }
    val reserveCancel = object : CardViewListener.IInputCardViewListener {
        override fun onClicked(text: String) {
            executor.run(DialogMessage.MyLockerReserveCancelSuccess) {
                service.reserveCancel(BuildConfig.SPR_TOKEN, text, it)
            }
        }
    }
    val shareUrlKey = object : CardViewListener.IInputCardViewListener {
        override fun onClicked(text: String) {
            executor.runGet<MyLockerModel>(DialogMessage.MyLockerShareUrlKeySuccess) {
                SPR.myLockerService().shareUrlKey(BuildConfig.SPR_TOKEN, text, it)
            }
        }
    }
}
