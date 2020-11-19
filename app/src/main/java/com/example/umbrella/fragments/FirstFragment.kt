package com.example.umbrella.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umbrella.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*


    class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val infoFragment = InfoFragment()

        val bottomsheetFragment = BottomSheet_Fragment()
        BottomSheetBehavior.STATE_COLLAPSED

        sheet_btn.visibility = View.VISIBLE

        sheet_btn.setOnClickListener {
            bottomsheetFragment.show(requireActivity().supportFragmentManager, "BottomSheetFragment")


        }

        info_bt.setOnClickListener {
            infoFragment.arguments=Bundle().also {
                it.putInt("key", 1)
            }
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer,infoFragment)
                ?.addToBackStack(null)
                ?.commit()

        }

        }

        }







