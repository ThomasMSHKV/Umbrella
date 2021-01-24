package com.example.umbrella.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.example.umbrella.R
import com.example.umbrella.data.Weather
import com.example.umbrella.data.WeatherApi
import com.example.umbrella.data.WeatherData
import com.example.umbrella.data.WeatherRepository
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_navigation.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.zip.Inflater

class FirstFragment : Fragment(), WeatherApi, CoroutineScope {

    override val coroutineContext = Dispatchers.Main


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val infoFragment = InfoFragment()
        val repository = WeatherRepository()
        val bottomsheetFragment = BottomSheet_Fragment()




        launch {
            val weather = repository.getData()
            withContext(Dispatchers.Main) {
                loader.visibility = View.GONE
                firstScreen.visibility = View.VISIBLE


            }
            weather.let {
                description.text = getString(R.string.description).format()
                temp.text = getString(R.string.temp).format()
                sunrise.text = getString(R.string.sunrise).format()
                sunset.text = getString(R.string.sunset).format()
                humidity.text = getString(R.string.humidity).format()
                pressure.text = getString(R.string.pressure).format()
                wind.text = getString(R.string.wind).format()

            }


        }

        BottomSheetBehavior.STATE_COLLAPSED
        sheet_btn.visibility = View.VISIBLE
        sheet_btn.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_DOWN ->

                        bottomsheetFragment.show(
                            requireActivity().supportFragmentManager,
                            "BottomSheetFragment"
                        )
                }
                return v?.onTouchEvent(event) ?: true
            }


        })

        info_bt.setOnClickListener {
            infoFragment.arguments = Bundle().also {
                it.putInt("key", 1)
            }
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, infoFragment)
                ?.addToBackStack(null)
                ?.commit()

        }

    }

    override fun getWeather(name: String?, apiKey: String): Call<WeatherData> {
        val repository = WeatherRepository()
        val weather = repository.getData()


        return getWeather(name, apiKey)


    }

    override fun getResponse(): Call<WeatherData> {

    }


}


