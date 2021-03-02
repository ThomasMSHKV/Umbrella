package com.example.umbrella

import androidx.annotation.UiThread
import androidx.fragment.app.Fragment
import androidx.test.annotation.UiThreadTest
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.umbrella.fragments.FirstFragment
import com.example.umbrella.ui.MainActivity
import junit.extensions.ActiveTestSuite

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val mainActivity = ActivityTestRule(MainActivity::class.java, false, true)


    @UiThreadTest
    fun testWeather() {
        onView(withId(R.id.sheet_btn)).check(matches(withId(R.id.sheet_btn)))


    }
}

