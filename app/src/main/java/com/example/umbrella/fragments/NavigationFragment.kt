package com.example.umbrella.fragments

import android.animation.ObjectAnimator
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.umbrella.R
import com.example.umbrella.utils.SharedPreferencesManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_navigation.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class NavigationFragment : Fragment(), CoroutineScope {


    override val coroutineContext: CoroutineContext = Dispatchers.IO

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nameEditText = nameEditText.text
        val lastnameEditText = lastNameEditText.text
        val mediaPlayer: MediaPlayer? = MediaPlayer.create(context, R.raw.drop_song)

        if (SharedPreferencesManager(requireContext()).getUsername().isNullOrEmpty().not()) {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FirstFragment())
                .commit()

        }

        button_register.setOnClickListener {
            if (nameEditText.isEmpty() || lastnameEditText.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Please enter text in Username/Ln",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            SharedPreferencesManager(requireContext()).putUsername(nameEditText.toString())
            SharedPreferencesManager(requireContext()).putLastName(lastnameEditText.toString())

            val objectAnimator = ObjectAnimator.ofFloat(it, "translationY", 520f)
            objectAnimator.duration = 700
            objectAnimator.start()
            Handler().postDelayed({ mediaPlayer?.start() }, 500)

            Handler().postDelayed({
                Toast.makeText(
                    it.context, "Welcome " + " $nameEditText $lastnameEditText", Toast.LENGTH_LONG
                ).show()
            }, 1500)

            Handler().postDelayed({
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.fragmentContainer, FirstFragment())
                    ?.commit()
            }, 1500)

        }


    }

}


