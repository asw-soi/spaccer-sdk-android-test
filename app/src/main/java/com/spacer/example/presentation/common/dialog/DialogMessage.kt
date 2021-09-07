

package com.spacer.example.presentation.common.dialog

import android.annotation.SuppressLint
import com.spacer.example.Application
import com.spacer.example.R

@SuppressLint("StaticFieldLeak")
class DialogMessage(titleId: Int, bodyId: Int) {

    private val context = Application.context

    var title: String
    var body: String

    init {
        this.title = context.getString(titleId)
        this.body = context.getString(bodyId)
    }

    override fun toString() = "${title},${body}"

    fun append(body: String): DialogMessage {
        this.body = "${this.body}\n${body}"
        return this
    }

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
