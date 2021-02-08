package com.example.umbrella.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import com.example.umbrella.R
import com.example.umbrella.data.WeatherData
import com.example.umbrella.data.WeatherRepository
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.coroutines.*


class FirstFragment : Fragment(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main
    val repository = WeatherRepository()
    var shodaTime: ShodaTime? = null

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
        viewFlipper()



        launch {
            withContext(Dispatchers.Main) {
                loader.visibility = View.GONE
                firstScreen.visibility = View.VISIBLE


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
    }

    fun formatData(data: WeatherData) {
        Log.d("LOG_TAG", "data.toString()")
        description.text = data.weather[0].description
        temp.text = data.main.temp.toString() + " °C"
        tempMax.text = data.main.temp_max.toString() + " °C"
        tempMin.text = data.main.temp_min.toString() + " °C"
        humidity.text = data.main.humidity.toString()
        feels_like.text = data.main.feels_like.toString() + " °C"
        pressure.text = data.main.pressure.toString()
        wind.text = data.wind.speed.toString()

    }


    fun viewFlipper() {
        val viewflipper = vFlipper
        viewflipper.isAutoStart
        viewflipper.flipInterval = 2000
//        shodaTime = ShodaTime.WINTER
//        shodaTime?.images()?.get(0)?.let { viewflipper.imageOne.setImageResource(it) }
//        shodaTime?.images()?.get(1)?.let { viewflipper.imageTwo.setImageResource(it) }
//        shodaTime?.images()?.get(2)?.let { viewflipper.imageThree.setImageResource(it) }
//        shodaTime?.images()?.get(3)?.let { viewflipper.imageFour.setImageResource(it) }
//
        shodaTime = ShodaTime.SUMMER
        shodaTime?.images()?.get(0)?.let { viewflipper.imageOne.setImageResource(it) }
        shodaTime?.images()?.get(1)?.let { viewflipper.imageTwo.setImageResource(it) }
        shodaTime?.images()?.get(2)?.let { viewflipper.imageThree.setImageResource(it) }
        shodaTime?.images()?.get(3)?.let { viewflipper.imageFour.setImageResource(it) }

//        shodaTime = ShodaTime.FALL
//        shodaTime?.images()?.get(0)?.let { viewflipper.imageOne.setImageResource(it) }
//        shodaTime?.images()?.get(1)?.let { viewflipper.imageTwo.setImageResource(it) }
//        shodaTime?.images()?.get(2)?.let { viewflipper.imageThree.setImageResource(it) }
//        shodaTime?.images()?.get(3)?.let { viewflipper.imageFour.setImageResource(it) }



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


