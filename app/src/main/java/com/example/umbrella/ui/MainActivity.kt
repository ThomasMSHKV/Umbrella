package com.example.umbrella.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umbrella.R
import com.example.umbrella.fragments.StartFragment


class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, StartFragment())
            .commit()



        }
    }


