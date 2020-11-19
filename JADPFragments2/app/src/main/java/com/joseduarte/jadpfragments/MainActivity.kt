package com.joseduarte.jadpfragments

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setPackageManager(packageManager)
    }

    companion object {
        private lateinit var pm : PackageManager
        fun setPackageManager(npm : PackageManager) { pm = npm }
        fun getPackageManager() : PackageManager = pm
    }

}