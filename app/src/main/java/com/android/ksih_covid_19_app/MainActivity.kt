package com.android.ksih_covid_19_app

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.android.ksih_covid_19_app.ui.liveByCountryAndStatus.LiveByCountryAndStatusViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mNavController: NavController
    private lateinit var viewModel: LiveByCountryAndStatusViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*viewModel = ViewModelProvider(this).get(LiveByCountryAndStatusViewModel::class.java)
        viewModel.loadData.observe(this, Observer {
            if (!it) {
                viewModel.loadData.value = true
                viewModel.getSummaryRemote()
            }
        })
*/
        mNavController = Navigation.findNavController(this, R.id.fragment)
    }
}
