package com.spacer.example.presentation.sprLocker

import androidx.fragment.app.Fragment
import com.spacer.example.BuildConfig
import com.spacer.example.presentation.common.SDKExecutor
import com.spacer.example.presentation.common.card.ICardInputViewListener
import com.spacer.example.presentation.common.dialog.DialogMessage
import com.spacer.example.presentation.common.token
import com.spacer.sdk.SPR
import com.spacer.sdk.models.sprLocker.SPRLockerModel
import com.spacer.sdk.models.sprLocker.SPRLockerUnitModel

class SPRLockerListener(fragment: Fragment) {
    private val service = SPR.sprLockerService()
    private val executor = SDKExecutor(fragment)

    val locker = object : ICardInputViewListener {
        override fun onClicked(text: String) {
            val spacerIds = text.split(",").map { it.trim() }
            executor.runList<SPRLockerModel>(DialogMessage.SPRLockerGetSuccess) {
                service.getLockers(token, spacerIds, it)
            }
        }
    }

    val unit = object : ICardInputViewListener {
        override fun onClicked(text: String) {
            val unitIds = text.split(",").map { it.trim() }
            executor.runList<SPRLockerUnitModel>(DialogMessage.SPRLockerGetUnitSuccess) {
                service.getUnits(token, unitIds, it)
            }
        }
    }
}
