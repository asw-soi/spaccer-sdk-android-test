package com.spacer.example.cbLocker

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spacer.example.R
import com.spacer.example.common.CardViewModel

class CBLockerViewModel : ViewModel() {
    val titleId = R.string.cb_title
    val scan = CardViewModel().apply { init(R.string.cb_scan_title, R.string.cb_scan_desc) }
    var put = CardViewModel().apply { init(R.string.cb_put_title, R.string.cb_put_desc, R.string.cb_put_hint) }
    var take = CardViewModel().apply { init(R.string.cb_take_title, R.string.cb_take_desc, R.string.cb_take_hint) }
    var takeUrlKey = CardViewModel().apply { init(R.string.cb_take_url_key_title, R.string.cb_take_url_key_desc, R.string.cb_take_url_key_hint) }
}