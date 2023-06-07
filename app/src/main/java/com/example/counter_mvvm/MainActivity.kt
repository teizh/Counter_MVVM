package com.example.counter_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.counter_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var counterViewModel: CounterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]

        counterViewModel.getCounter().observe(this) { counter ->
            binding.counterTextView.text = counter.toString()
        }

        binding.incrementButton.setOnClickListener {
            counterViewModel.incrementCounter()
        }

        binding.decrementButton.setOnClickListener {
            counterViewModel.decrementCounter()
        }
    }
}