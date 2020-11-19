package com.joseduarte.jadpfragments

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_camera.*
import android.Manifest


class CameraFragment : Fragment() {

    private val hasCapturedRequestedImage = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val v : View? = getView()
        val button : Button? = v?.findViewById<Button>(R.id.makePhotoButton)
        button?.setOnClickListener(View.OnClickListener {
            doPhoto()
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CameraFragment().apply {
            }
    }

    fun doPhoto() {
        if(
            getContext()?.let {
                ContextCompat.checkSelfPermission(it, "android.permission.CAMERA")
            } == PackageManager.PERMISSION_GRANTED
        ) {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(MainActivity.getPackageManager())?.also {
                    startActivityForResult(takePictureIntent, hasCapturedRequestedImage)
                }

            }
        }
        else {
            ActivityCompat.requestPermissions(
                (context as Activity)!!,
                arrayOf(Manifest.permission.CAMERA),
                hasCapturedRequestedImage
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        println("holaaaaaaaa")
        if (requestCode == hasCapturedRequestedImage && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            photo.setImageBitmap(imageBitmap)
        }
    }
}