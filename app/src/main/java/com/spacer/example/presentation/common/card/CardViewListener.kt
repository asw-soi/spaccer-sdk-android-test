package com.spacer.example.presentation.common.card

object CardViewListener {
    interface ISimpleCardViewListener {
        fun onClicked()
    }

    interface IInputCardViewListener {
        fun onClicked(text: String)
    }
}
