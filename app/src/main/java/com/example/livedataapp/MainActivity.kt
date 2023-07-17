package com.example.livedataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedataapp.data.MainViewModel
import com.example.livedataapp.data.MainViewModelFactory
import com.example.livedataapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // criando binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // criando viewModels
        viewModelFactory = MainViewModelFactory(50)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        // criando observador que ira observar o valor modificado na nossa variavel total na classe model
        // e retornar o valor setado no textView2.
        viewModel.totalSum.observe(
            this,
            Observer {
                binding.txtView2.text = it.toString()
            }
        )

        binding.btnId.setOnClickListener {
            println(viewModel.totalSum)
            val value: Int = binding.edtText.text.toString().toInt()
            viewModel.setTotal(value)
        }
    }
}