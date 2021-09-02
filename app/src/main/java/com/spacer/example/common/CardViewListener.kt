package com.spacer.example.common

object CardViewListener {
    interface ISimpleCardViewListener {
        fun onClicked()
    }

    interface IInputCardViewListener {
        fun onClicked(text: String)
    }
}
