package com.android.ksih_covid_19_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {
    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavController = Navigation.findNavController(this, R.id.fragment)
        setDestinationListener()

    }

    private fun setDestinationListener(){
        mNavController.addOnDestinationChangedListener{controller, destination, arguments ->
            val dest = resources.getResourceName(destination.id)

            when(destination.id) {
               R.id.homeFragment, R.id.summaryFragment -> {
                    hideCustomToolBar()
                }
                else -> {
                    showCustomToolBar()
                }
            }
        }

    }

    private fun hideCustomToolBar() {
        supportActionBar?.hide()
    }

    private fun showCustomToolBar() {
        supportActionBar?.show()
    }
}