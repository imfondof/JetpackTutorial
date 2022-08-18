package com.imfondof.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val plus = findViewById<Button>(R.id.plus)
        text = findViewById(R.id.text)
        plus.setOnClickListener {
            mainViewModel.counter++
            refresh()
        }

        refresh()
        showFragment()
    }

    private fun showFragment() {
        var transaction = supportFragmentManager.beginTransaction()
        var mainFragment = MainFragment.newInstance("", "")
        transaction.replace(R.id.root, mainFragment);

        transaction.commit()
    }

    private fun refresh() {
        text.text = mainViewModel.counter.toString()
    }
}