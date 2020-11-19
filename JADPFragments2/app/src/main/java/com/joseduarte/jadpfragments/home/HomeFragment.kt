package com.joseduarte.jadpfragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.joseduarte.jadpfragments.FragmentDirections
import com.joseduarte.jadpfragments.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        browser_button.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_browserFragment)
            println("SUCCES")
        })

        calculator_button.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_calculatorFragment)
            println("SUCCES")
        })

        camera_button.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_cameraFragment)
            println("SUCCES")
        })
    }
}