package com.imfondof.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(MyObserver())

        val observer2 = MyObserver2(lifecycle)
        observer2.method()
        lifecycle.addObserver(observer2)
    }
}