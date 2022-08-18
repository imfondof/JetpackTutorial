package com.imfondof.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.imfondof.viewmodel.viewmodel2.MainViewModel2
import com.imfondof.viewmodel.viewmodel2.MainViewModelFactory

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    lateinit var mainViewModel2: MainViewModel2
    private lateinit var text: TextView
    private lateinit var plus: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private fun refresh() {
        text.text = mainViewModel2.counter.toString()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_main, container, false)
        text = view.findViewById(R.id.text)
        plus = view.findViewById(R.id.plus)

        init()
        return view
    }

    private fun init() {
        mainViewModel2 = ViewModelProvider(this,MainViewModelFactory(3)).get(MainViewModel2::class.java)
        plus.setOnClickListener {
            mainViewModel2.counter++
            refresh()
        }
        refresh()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}