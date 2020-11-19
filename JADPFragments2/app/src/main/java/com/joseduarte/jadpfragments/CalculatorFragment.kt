package com.joseduarte.jadpfragments

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_calculator.*


class CalculatorFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CalculatorFragment().apply {
            }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        SumaBtn.setOnClickListener(View.OnClickListener {
            val NumOne : Int = Integer.parseInt(numOne.text.toString())
            val NumTwo : Int = Integer.parseInt(numTwo.text.toString())
            print(Integer.toString(NumOne) + " " + Integer.toString(NumTwo))
            val bundle = bundleOf("numOne" to NumOne, "numTwo" to NumTwo)

            Navigation.findNavController(it).navigate(R.id.action_calculatorFragment_to_sumaFragment, bundle)
            println("SUCCES")
        })

        RestaBtn.setOnClickListener(View.OnClickListener {
            val NumOne : Int = Integer.parseInt(numOne.text.toString())
            val NumTwo : Int = Integer.parseInt(numTwo.text.toString())
            val bundle = bundleOf("numOne" to NumOne, "numTwo" to NumTwo)

            Navigation.findNavController(it).navigate(R.id.action_calculatorFragment_to_restaFragment, bundle)
            println("SUCCES")
        })

        DivisionBtn.setOnClickListener(View.OnClickListener {
            val NumOne : Int = Integer.parseInt(numOne.text.toString())
            val NumTwo : Int = Integer.parseInt(numTwo.text.toString())
            val bundle = bundleOf("numOne" to numOne.text.toString(), "numTwo" to numTwo.text.toString())

            Navigation.findNavController(it).navigate(R.id.action_calculatorFragment_to_divisionFragment, bundle)
            println("SUCCES")
        })
    }
}