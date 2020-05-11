package com.android.ksih_covid_19_app.ui.summary

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.ksih_covid_19_app.R
import com.google.android.material.snackbar.Snackbar
import org.jetbrains.anko.longToast

class SummaryFragment : Fragment() {

//    var connectivityReceiver: ConnectivityReceiver? = null
    private lateinit var progress:ProgressBar
    private lateinit var viewModel: MainSummaryViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SummaryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.summary_fragment, container, false).apply {
            viewModel =
                ViewModelProvider(this@SummaryFragment).get(MainSummaryViewModel::class.java)

        }

        progress = root.findViewById(R.id.progress)
        recyclerView = root.findViewById(R.id.summary_recyclerView)
        val back = root.findViewById<ImageView>(R.id.go_back)
        back.setOnClickListener { Navigation.findNavController(root).navigate(R.id.homeFragment) }

        progress.isVisible = true

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchSummaryList()
        setUpAdapter()
        setUpObservers()
    }
    private fun setUpObservers() {
        viewModel.summaryList.observe(viewLifecycleOwner, Observer {
            adapter.updateSummaryList(it)
            progress.isVisible = false
        })

        viewModel.toastMessage.observe(viewLifecycleOwner, Observer {
            activity?.longToast(it)
        })
    }
    private fun setUpAdapter(){
        adapter = SummaryAdapter(viewModel)
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        //setUp network check
        //Register connectivity BroadcastReceiver
//        connectivityReceiver = ConnectivityReceiver()
//        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
//        activity?.registerReceiver(connectivityReceiver, intentFilter)

    }

    override fun onDestroy() {
//        requireActivity().unregisterReceiver(connectivityReceiver)
        super.onDestroy()
    }

    // checking network
//   inner class ConnectivityReceiver : BroadcastReceiver() {
//        override fun onReceive(context: Context, intent: Intent) {
//            val connectivityManager = context.getSystemService(
//                Context.CONNECTIVITY_SERVICE
//            ) as ConnectivityManager
//            val networkInfo = connectivityManager.activeNetworkInfo
//            if (networkInfo != null && networkInfo.isConnected) {
//                val snackbar = Snackbar
//                    .make(
//                        recyclerView,
//                        "Connection Available ",
//                        Snackbar.LENGTH_LONG
//                    )
//                    .setAction(
//                        "Reload Data"
//                    ) { view: View? ->
//                        viewModel.fetchSummaryList()
//                        setUpAdapter()
//                        setUpObservers()
//                    }
//                // customizing snackbar
//                snackbar.setActionTextColor(Color.BLACK)
//                val view = snackbar.view
//                view.setBackgroundColor(
//                    ContextCompat.getColor(
//                        context,
//                        R.color.colorPrimary
//                    )
//                )
//                snackbar.setText("Connection Available")
//                snackbar.setTextColor(Color.WHITE)
//                snackbar.show()
//
//            } else {
//                val snackbar = Snackbar
//                    .make(
//                        recyclerView,
//                        "No internet Connection! ",
//                        Snackbar.LENGTH_LONG
//                    )
//                // customizing snackbar
//                snackbar.setActionTextColor(Color.BLACK)
//                val view = snackbar.view
//                view.setBackgroundColor(
//                    ContextCompat.getColor(
//                        context,
//                        R.color.colorPrimary
//                    )
//                )
//                snackbar.setText("No internet Connection!")
//                snackbar.setTextColor(Color.WHITE)
//                snackbar.show()
//            }
//        }
//    }
}
