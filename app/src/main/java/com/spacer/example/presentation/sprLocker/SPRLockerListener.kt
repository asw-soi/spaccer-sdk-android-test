package com.spacer.example.presentation.sprLocker

import androidx.fragment.app.Fragment
import com.spacer.example.BuildConfig
import com.spacer.example.presentation.common.SDKExecutor
import com.spacer.example.presentation.common.card.CardViewListener
import com.spacer.example.presentation.common.dialog.DialogMessage
import com.spacer.sdk.SPR
import com.spacer.sdk.models.myLocker.MyLockerModel
import com.spacer.sdk.models.sprLocker.SPRLockerModel
import com.spacer.sdk.models.sprLocker.SPRLockerUnitModel


class SPRLockerListener(private val fragment: Fragment) {

    private val service = SPR.sprLockerService()
    private val executor = SDKExecutor(fragment)

    val locker = object : CardViewListener.IInputCardViewListener {
        override fun onClicked(text: String) {
            val spacerIds = text.split(",").map { it.trim() }
            executor.runList<SPRLockerModel>(DialogMessage.SPRLockerGetSuccess) {
                service.getLockers(BuildConfig.SPR_TOKEN, spacerIds, it)
            }
        }
    }

    val unit = object : CardViewListener.IInputCardViewListener {
        override fun onClicked(text: String) {
            val unitIds = text.split(",").map { it.trim() }
            executor.runList<SPRLockerUnitModel>(DialogMessage.SPRLockerGetUnitSuccess) {
                service.getUnits(BuildConfig.SPR_TOKEN, unitIds, it)
            }
        }
    }
}
