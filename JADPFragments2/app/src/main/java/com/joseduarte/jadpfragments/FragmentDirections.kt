package com.joseduarte.jadpfragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

class FragmentDirections private constructor() {
    companion object {
        fun linkBrowser(): NavDirections = ActionOnlyNavDirections(R.id.action_homeFragment_to_browserFragment)

        fun linkCamera(): NavDirections = ActionOnlyNavDirections(R.id.action_homeFragment_to_cameraFragment)

        fun linkCalculator(): NavDirections = ActionOnlyNavDirections(R.id.action_homeFragment_to_calculatorFragment)
    }
}