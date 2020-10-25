package com.example.umbrella.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umbrella.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheet_Fragment: BottomSheetDialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottomsheet_fragment,container,false)
    }


}