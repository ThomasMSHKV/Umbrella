package com.example.umbrella.fragments

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.umbrella.R
import kotlinx.android.synthetic.main.fragment_start.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class StartFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navigationFragment = NavigationFragment()



        Handler().postDelayed({fragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentContainer,NavigationFragment())
            ?.commit()},2500)

        super.onViewCreated(view, savedInstanceState)
        loading_um.animate().apply {
            duration = 2000
            rotationYBy(360f)
        }.start()
    }

}


