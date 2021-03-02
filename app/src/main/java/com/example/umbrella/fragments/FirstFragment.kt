package com.example.umbrella.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.fragment.app.Fragment
import com.example.umbrella.R
import com.example.umbrella.data.WeatherData
import com.example.umbrella.data.WeatherRepository
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottomsheet_fragment.*
import kotlinx.android.synthetic.main.bottomsheet_fragment.view.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.coroutines.*


class FirstFragment : Fragment(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main
    val repository = WeatherRepository()
    var condition = 0
    lateinit var viewflipper: ViewFlipper
    private var clotherForWeather: TextView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val infoFragment = InfoFragment()
        val bottomsheetFragment = BottomSheet_Fragment()
        getWeather()
        chooserWeather()
        viewFlipper()
        chooserDescription()
        bottomSheetDescription()

        clotherForWeather = requireActivity().findViewById(R.id.clothes_for_weather)
        viewflipper = requireActivity().findViewById(R.id.view_Flipper)

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

        info_button.setOnClickListener {
            infoFragment.arguments = Bundle().also {
                it.putInt("key", 1)
            }
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, infoFragment)
                ?.addToBackStack(null)
                ?.commit()

        }

    }


    @SuppressLint("SetTextI18n")
    fun formatData(data: WeatherData) {
        description.text = data.weather[0].description
        temp.text = data.main.temp.toString() + " °C"
        tempMax.text = data.main.temp_max.toString() + " °C"
        tempMin.text = data.main.temp_min.toString() + " °C"
        humidity.text = data.main.humidity.toString()
        feels_like.text = data.main.feels_like.toString() + " °C"
        pressure.text = data.main.pressure.toString()
        wind.text = data.wind.speed.toString()

        condition = data.main.feels_like.toInt()

        viewFlipper()
        bottomSheetDescription()


    }


    fun chooserWeather(): ShodaTime {
        Log.d("MAIN", "NOT ERROR1")
        when (condition) {
            in 0 downTo -5 -> return ShodaTime.FALL
            in -6 downTo -40 -> return ShodaTime.WINTER
            in 1..10 -> return ShodaTime.SPRING
            in 11..70 -> return ShodaTime.SUMMER

        }
        return ShodaTime.WINTER

    }

    private fun viewFlipper() {
        launch(Dispatchers.Main) {
            Log.d("MAIN", "${chooserWeather()}")

            viewflipper.startFlipping()
            viewflipper.flipInterval = 2000
            viewflipper.isAutoStart = true
            chooserWeather().images().get(0).let { viewflipper.imageOne.setImageResource(it) }
            chooserWeather().images().get(1).let { viewflipper.imageTwo.setImageResource(it) }
            chooserWeather().images().get(2).let { viewflipper.imageThree.setImageResource(it) }
            chooserWeather().images().get(3).let { viewflipper.imageFour.setImageResource(it) }


        }
    }

    fun chooserDescription(): CharSequence {
        Log.d("MAIN", "NOT ERROR3")
        when (condition) {
            //COLD
            in 0 downTo -3 -> return getString(R.string.zero_three)
            in -4 downTo -7 -> return getString(R.string.minus_four_seven)
            in -8 downTo -18 -> return getString(R.string.minus_eight_eighteen)
            in -19 downTo -80 -> return getString(R.string.minus_nineteen_eighty)
            //WORM
            in 1..3 -> return getString(R.string.plus_one_three)
            in 4..5 -> return getString(R.string.plus_four_five)
            in 6..10 -> return getString(R.string.plus_six_ten)
            in 11..15 -> return getString(R.string.plus_eleven_fifteen)
            in 16..21 -> return getString(R.string.plus_sixteen_twentyOne)
            in 22..27 -> return getString(R.string.plus_twentyTwo_twentySeven)
            in 28..35 -> return getString(R.string.plus_twentyEight_thirtyFive)
            in 36..60 -> return getString(R.string.plus_thirtySix_sixty)

        }
        return getString(R.string.zero_three)

    }

    private fun bottomSheetDescription() {
        Log.d("MAIN_DES", "${chooserDescription()}")
        launch(Dispatchers.Main) {
            chooserDescription().let {  clotherForWeather?.text = it  }

        }

    }


    fun getWeather() {
        btnCity.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                val getInfoWeather = repository.getData(searchCity.text.toString()).await()

                withContext(Dispatchers.Main) {
                    if (getInfoWeather != null) {
                        formatData(getInfoWeather)
                    }
                }
            }
        }
    }
}


