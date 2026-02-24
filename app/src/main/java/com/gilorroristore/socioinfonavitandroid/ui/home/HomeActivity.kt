package com.gilorroristore.socioinfonavitandroid.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.gilorroristore.socioinfonavitandroid.databinding.ActivityHomeBinding
import com.gilorroristore.socioinfonavitandroid.domain.model.BenevitsInfo
import com.gilorroristore.socioinfonavitandroid.ui.home.adapter.BenevitsAdapter
import com.gilorroristore.socioinfonavitandroid.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()
    private lateinit var adapter1: BenevitsAdapter
    private lateinit var adapter2: BenevitsAdapter
    private lateinit var adapter3: BenevitsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        initObservers()
    }

    private fun initUI() {
        getBenevitsList()
        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {}
            }
        )

        adapter1 = BenevitsAdapter { benevit ->
            showItemSelected(benevit)
        }

        adapter2 = BenevitsAdapter { benevit ->
            showItemSelected(benevit)
        }

        adapter3 = BenevitsAdapter { benevit ->
            showItemSelected(benevit)
        }
        binding.rvBenevits1.adapter = adapter1
        binding.rvBenevits2.adapter = adapter2
        binding.rvBenevits3.adapter = adapter3

        binding.ivLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun getBenevitsList() {
        homeViewModel.getBenevitsListFirstRow()
    }

    private fun initObservers() {

        homeViewModel.benevitsList.observe(this) { state ->
            when(state) {
                is HomeState.Error -> TODO()
                HomeState.Loading -> showBenevits(false)
                is HomeState.Success -> {
                    showBenevits(true)
                    val randomList1 =  state.benevitsList.shuffled()
                    val randomList2 =  state.benevitsList.shuffled()
                    val randomList3 =  state.benevitsList.shuffled()
                    adapter1.updateList(randomList1)
                    adapter2.updateList(randomList2)
                    adapter3.updateList(randomList3)
                }
            }
        }
    }


    private fun showBenevits(show: Boolean) {
        binding.clBenevits.isVisible = show
        binding.sflItems.isVisible = !show
    }

    private fun showItemSelected(benevit: BenevitsInfo) {
        Toast.makeText(this, "Item seleccionado ${getString(benevit.title)}", Toast.LENGTH_SHORT)
            .show()
    }
}