package com.android.ksih_covid_19_app.ui.summary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.ksih_covid_19_app.R
import org.jetbrains.anko.longToast

class SummaryFragment : Fragment() {

    private lateinit var viewModel: MainSummaryViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SummaryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.summary_fragment, container, false).apply {
            viewModel =
                ViewModelProviders.of(this@SummaryFragment).get(MainSummaryViewModel::class.java)

        }

        recyclerView = root.findViewById(R.id.summary_recyclerView)

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
}
