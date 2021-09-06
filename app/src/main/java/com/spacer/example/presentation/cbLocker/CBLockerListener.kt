package com.spacer.example.presentation.cbLocker

import androidx.fragment.app.Fragment
import com.spacer.example.BuildConfig
import com.spacer.example.presentation.common.card.CardViewListener
import com.spacer.example.presentation.common.SDKExecutor
import com.spacer.example.presentation.common.dialog.DialogMessage
import com.spacer.sdk.SPR
import com.spacer.sdk.models.sprLocker.SPRLockerModel


class CBLockerListener(private val fragment: Fragment) {

    private val service = SPR.cbLockerService()
    private val executor = SDKExecutor(fragment)

    val scan = object : CardViewListener.ISimpleCardViewListener {
        override fun onClicked() {
            val context = fragment.context ?: return

            executor.runList<SPRLockerModel>(DialogMessage.CbLockerScanSuccess) {
                service.scan(BuildConfig.SPR_TOKEN, context, it)
            }
        }
    }

    val put = object : CardViewListener.IInputCardViewListener {
        override fun onClicked(text: String) {
            val context = fragment.context ?: return

            executor.run(DialogMessage.CbLockerPutSuccess) {
                service.put(BuildConfig.SPR_TOKEN, context, text, it)
            }
        }
    }

    val take = object : CardViewListener.IInputCardViewListener {
        override fun onClicked(text: String) {
            val context = fragment.context ?: return

            executor.run(DialogMessage.CbLockerTakeSuccess) {
                service.take(BuildConfig.SPR_TOKEN, context, text, it)
            }
        }
    }
    val takeUrlKey = object : CardViewListener.IInputCardViewListener {
        override fun onClicked(text: String) {
            val context = fragment.context ?: return

            executor.run(DialogMessage.CbLockerTakeUrlKeySuccess) {
                SPR.cbLockerService().takeWithUrlKey(BuildConfig.SPR_TOKEN, context, text, it)
            }
        }
    }
}
