package com.android.ksih_covid_19_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.android.ksih_covid_19_app.R

class MainActivity : AppCompatActivity() {
    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavController = Navigation.findNavController(this,
            R.id.fragment
        )
    }
}
