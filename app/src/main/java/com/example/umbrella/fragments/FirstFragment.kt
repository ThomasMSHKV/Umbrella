package com.example.umbrella.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umbrella.R
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







