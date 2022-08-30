package com.pr.kotlin_flow_stateflow_sharedflow_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.pr.kotlin_flow_stateflow_sharedflow_livedata.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.buttonlivedata.setOnClickListener {
            mainViewModel.invokeLivedata()
        }
        binding.buttonstateflow.setOnClickListener {
            mainViewModel.invokestateflow()
        }
        binding.buttonsharedflow.setOnClickListener {
            mainViewModel.invokesharedflow()
        }
        binding.buttonflow.setOnClickListener {
            mainViewModel.invokeflow()
        }


        mainViewModel.livedata.observe(this@MainActivity, {
            binding.buttonlivedata.text = it
        })






        GlobalScope.launch(Dispatchers.Main) {

//            mainViewModel.stateflow.collect {
//                binding.buttonstateflow.text = it
//            }
//            mainViewModel.sharedFlow.collect {
//                binding.buttonsharedflow.text = it
//            }
            mainViewModel.invokeflow().collect{
                binding.buttonflow.text="$it"
            }



        }

    }
}