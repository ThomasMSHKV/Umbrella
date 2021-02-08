package com.example.umbrella.fragments

import android.media.Image
import com.example.umbrella.R

enum class ShodaTime {
    WINTER,
    SPRING,
    SUMMER,
    FALL;



    fun Name(): String {
        when(this) {
            WINTER -> return "ЗИМА"
            SPRING -> return "ВЕСНА"
            SUMMER -> return "ЛЕТО"
            FALL ->  return  "ОСЕНЬ"
        }
    }

    fun images(): List<Int> {
        when(this) {
            WINTER -> return listOf(R.drawable.vinter1,R.drawable.vinter2,R.drawable.vinter3, R.drawable.vinter4)
            SPRING -> return listOf(R.drawable.spring1,R.drawable.spring2,R.drawable.spring3,R.drawable.spring4)
            SUMMER -> return listOf(R.drawable.summer1, R.drawable.summer2, R.drawable.summer3,R.drawable.summer4)
            FALL ->  return  listOf(R.drawable.fall1,R.drawable.fall2,R.drawable.fall3,R.drawable.fall4)
        }
    }


}