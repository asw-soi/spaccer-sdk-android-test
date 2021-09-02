package com.spacer.example.cbLocker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.spacer.example.R
import com.spacer.example.common.CardViewListener
import com.spacer.example.databinding.FragmentCbLockerBinding


class CBLockerListener(private val fragment: Fragment) {
    val scan = object :CardViewListener.ISimpleCardViewListener{
        override fun onClicked() {
            TODO("Not yet implemented")
        }
    }
    val put = object :CardViewListener.IInputCardViewListener{
        override fun onClicked(text: String) {
            TODO("Not yet implemented")
        }
    }
    val take = object :CardViewListener.IInputCardViewListener{
        override fun onClicked(text: String) {
            TODO("Not yet implemented")
        }
    }
    val takeUrlKey = object :CardViewListener.IInputCardViewListener{
        override fun onClicked(text: String) {
            TODO("Not yet implemented")
        }
    }
}
