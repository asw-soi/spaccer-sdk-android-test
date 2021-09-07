package com.spacer.example.presentation.cbLocker

import androidx.fragment.app.Fragment

import com.spacer.example.presentation.common.SDKExecutor
import com.spacer.example.presentation.common.card.ICardInputViewListener
import com.spacer.example.presentation.common.card.ICardSimpleViewListener
import com.spacer.example.presentation.common.dialog.DialogMessage
import com.spacer.example.presentation.common.token
import com.spacer.sdk.SPR
import com.spacer.sdk.models.sprLocker.SPRLockerModel

class CBLockerListener(private val fragment: Fragment) {
    private val service = SPR.cbLockerService()
    private val executor = SDKExecutor(fragment)

    val scan = object : ICardSimpleViewListener {
        override fun onClicked() {
            val context = fragment.context ?: return

            executor.runList<SPRLockerModel>(DialogMessage.CbLockerScanSuccess) {
                service.scan(context, token, it)
            }
        }
    }

    val put = object : ICardInputViewListener {
        override fun onClicked(text: String) {
            val context = fragment.context ?: return

            executor.run(DialogMessage.CbLockerPutSuccess) {
                service.put(context, token, text, it)
            }
        }
    }

    val take = object : ICardInputViewListener {
        override fun onClicked(text: String) {
            val context = fragment.context ?: return

            executor.run(DialogMessage.CbLockerTakeSuccess) {
                service.take(context, token, text, it)
            }
        }
    }

    val takeUrlKey = object : ICardInputViewListener {
        override fun onClicked(text: String) {
            val context = fragment.context ?: return

            executor.run(DialogMessage.CbLockerTakeUrlKeySuccess) {
                SPR.cbLockerService().takeWithUrlKey(context, token, text, it)
            }
        }
    }
}
