package com.spacer.example.presentation.myLocker

import androidx.fragment.app.Fragment
import com.spacer.example.BuildConfig
import com.spacer.example.presentation.common.SDKExecutor
import com.spacer.example.presentation.common.card.ICardInputViewListener
import com.spacer.example.presentation.common.card.ICardSimpleViewListener
import com.spacer.example.presentation.common.dialog.DialogMessage
import com.spacer.example.presentation.common.token
import com.spacer.sdk.SPR
import com.spacer.sdk.models.myLocker.MyLockerModel

class MyLockerListener(fragment: Fragment) {
    private val service = SPR.myLockerService()
    private val executor = SDKExecutor(fragment)

    val get = object : ICardSimpleViewListener {
        override fun onClicked() {
            executor.runList<MyLockerModel>(DialogMessage.MyLockerGetSuccess) {
                service.get(token, it)
            }
        }
    }

    val reserve = object : ICardInputViewListener {
        override fun onClicked(text: String) {
            executor.runGet<MyLockerModel>(DialogMessage.MyLockerReserveSuccess) {
                service.reserve(token, text, it)
            }
        }
    }

    val reserveCancel = object : ICardInputViewListener {
        override fun onClicked(text: String) {
            executor.run(DialogMessage.MyLockerReserveCancelSuccess) {
                service.reserveCancel(token, text, it)
            }
        }
    }

    val shareUrlKey = object : ICardInputViewListener {
        override fun onClicked(text: String) {
            executor.runGet<MyLockerModel>(DialogMessage.MyLockerShareUrlKeySuccess) {
                SPR.myLockerService().shareUrlKey(token, text, it)
            }
        }
    }
}
