package com.joseduarte.jadpfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_division2.*

class SumaFragment : Fragment() {
    private var param1: String = ""
    private var param2: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("numOne").toString()
            param2 = it.getString("numTwo").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_suma2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        divResult.text = (Integer.parseInt(param1) + Integer.parseInt(param2)).toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DivisionFragment().apply {
                arguments = Bundle().apply {
                    putString("numOne", param1)
                    putString("numTwo", param2)
                }
            }
    }
}