package com.example.umbrella.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.umbrella.R
import com.example.umbrella.fragments.BottomSheet_Fragment
import com.example.umbrella.fragments.StartFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomsheetFragment = BottomSheet_Fragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, StartFragment())
            .commit()



        sheet_btn.setOnClickListener {
            (View.GONE)
            bottomsheetFragment.show(supportFragmentManager, "BottomSheetFragment")


        }
    }
}

