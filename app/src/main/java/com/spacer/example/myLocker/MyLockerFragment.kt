package com.spacer.example.myLocker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.spacer.example.R
import com.spacer.example.databinding.FragmentMyLockerBinding
import com.spacer.example.databinding.FragmentSprLockerBinding


class MyLockerFragment : Fragment() {
    private lateinit var binding: FragmentMyLockerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_locker, container, false)
        binding.listener = this
        binding.lifecycleOwner = this

        return binding.root
    }
}