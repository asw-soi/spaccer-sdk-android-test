package com.spacer.example.presentation.common.dialog

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.spacer.example.Application
import com.spacer.example.R
import com.spacer.example.presentation.extensions.FragmentExtensions.showErrorDialog
import com.spacer.example.presentation.extensions.FragmentExtensions.showSuccessDialog
import com.spacer.example.presentation.extensions.FragmentExtensions.startLoading
import com.spacer.example.presentation.extensions.FragmentExtensions.stopLoading
import com.spacer.sdk.data.ICallback
import com.spacer.sdk.data.IResultCallback
import com.spacer.sdk.data.SPRError
import com.spacer.sdk.data.extensions.LoggerExtensions.logd
import com.spacer.sdk.models.sprLocker.SPRLockerModel

class DialogMessage(val titleId: Int, val bodyId: Int) {
    private val context = Application.context
    override fun toString() = "${title},${body}"

    val title get() = context.getString(titleId)
    val body get() = context.getString(bodyId)

    companion object {
        val CbLockerScanSuccess = DialogMessage(R.string.success_title, R.string.cb_scan_success_message)
        val CbLockerPutSuccess = DialogMessage(R.string.success_title, R.string.cb_put_success_message)
        val CbLockerTakeSuccess = DialogMessage(R.string.success_title, R.string.cb_take_success_message)
        val CbLockerTakeUrlKeySuccess = DialogMessage(R.string.success_title, R.string.cb_take_url_key_success_message)
        val MyLockerGetSuccess = DialogMessage(R.string.success_title, R.string.my_get_success_message)
        val MyLockerReserveSuccess = DialogMessage(R.string.success_title, R.string.my_reserve_success_message)
        val MyLockerReserveCancelSuccess = DialogMessage(R.string.success_title, R.string.my_reserve_cancel_success_message)
        val MyLockerShareUrlKeySuccess = DialogMessage(R.string.success_title, R.string.my_share_url_key_success_message)
        val SPRLockerGetSuccess = DialogMessage(R.string.success_title, R.string.spr_locker_get_success_message)
        val SPRLockerGetUnitSuccess = DialogMessage(R.string.success_title, R.string.spr_unit_get_success_message)
    }
}
