package com.berkayatmali.project1.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.berkayatmali.project1.NewsDataModel
import com.berkayatmali.project1.R
import com.berkayatmali.project1.adapter.NewsAdapter
import com.berkayatmali.project1.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.news_row.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


class HomeFragment : Fragment() {

    private val newsAdapterLM = LinearLayoutManager(activity)
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private val newsAdapter = NewsAdapter()

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        setUpUI()
        setUpLogic()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        inflater.inflate(R.menu.options_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.about -> {
                Toast.makeText(context, "ABOUTA GELDI",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.settings -> {
                Toast.makeText(context, "settingse GELDI",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.logOut -> {
                Toast.makeText(context, "logOuta GELDI",Toast.LENGTH_SHORT).show()
                logOut()
                return true
            }
        }
        return false
    }

    private fun setUpLogic() {
        binding.searchview.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText?.length!! >= 3) {
                    viewModel.aramaDegeri.postValue(newText)
                    viewModel.runFiltered(newText)
                } else {
                    viewModel.prepareList()
                }
                return true
            }
        })
    }

    private fun setUpUI() {
        binding.rvHomeList.layoutManager = newsAdapterLM
        binding.rvHomeList.adapter = newsAdapter

        viewModel.list.observe(viewLifecycleOwner){
            newsAdapter.submitList(it)
        }

        viewModel.filteredList.observe(viewLifecycleOwner){
            newsAdapter.submitList(it)
        }
    }

    private fun logOut() {
        val preferences: SharedPreferences =
            requireActivity().getSharedPreferences("Uyelik", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
        activity?.finish()
    }
}

