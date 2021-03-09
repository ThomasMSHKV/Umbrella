package com.example.umbrella.fragments
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umbrella.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottomsheet_fragment.*

class BottomSheet_Fragment(var text: String) : BottomSheetDialogFragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottomsheet_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bottomSheetDescription()

        buttonSheetBtn.setOnClickListener {
            dismiss()

        }
    }

    private fun bottomSheetDescription() {
        Log.d("BOTTOMSHEET", text)

        clothes_for_weather.text = text

    }


}



