package com.example.umbrella.fragments

import com.example.umbrella.R

enum class ShodaTime {
    WINTER,
    SPRING,
    SUMMER,
    FALL;



    fun images(): List<Int> {
        when(this) {
            WINTER -> return listOf(R.drawable.winter1,R.drawable.winter2,R.drawable.winter3, R.drawable.winter4)
            SPRING -> return listOf(R.drawable.spring1,R.drawable.spring2,R.drawable.spring3,R.drawable.spring4)
            SUMMER -> return listOf(R.drawable.summer1, R.drawable.summer2, R.drawable.summer3,R.drawable.summer4)
            FALL ->  return  listOf(R.drawable.fall1,R.drawable.fall2,R.drawable.fall3,R.drawable.fall4)
        }
    }

}