package com.imfondof.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.text)
        val plus = findViewById<Button>(R.id.plus)
        text = findViewById(R.id.text)

        plus.setOnClickListener {
            viewModel.plusOne()
        }

        val countReserved = 5
        viewModel = ViewModelProvider(this, MainViewModelFactory(countReserved)).get(MainViewModel::class.java)
        viewModel.counter.observe(this, Observer { count ->
            text.text = count.toString()
        })
    }
}