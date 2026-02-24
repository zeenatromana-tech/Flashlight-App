package com.yourpackage

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var toggleFlashLightOnOff: ToggleButton? = null
    private var cameraManager: CameraManager? = null
    private var getCameraID: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Register the ToggleButton with specific ID
        toggleFlashLightOnOff = findViewById(R.id.toggle_flashlight)

        // CameraManager to interact with camera devices
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager

        // Exception is handled to check whether the camera resource is being used by another service or not
        try {
            // 0 means back camera unit, 1 means front camera unit
            getCameraID = cameraManager!!.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    // RequiresApi is set because devices below API level 23 don't have the flash unit with the camera
    @RequiresApi(Build.VERSION_CODES.M)
    fun toggleFlashLight(view: View?) {
        if (toggleFlashLightOnOff!!.isChecked) {
            // Exception is handled to check whether the camera resource is being used by another service or not
            try {
                // true sets the torch in ON mode
                cameraManager!!.setTorchMode(getCameraID!!, true)

                // Inform the user about the flashlight status using Toast message
                Toast.makeText(this@MainActivity, "Flashlight is turned ON", Toast.LENGTH_SHORT).show()
            } catch (e: CameraAccessException) {
                // Prints stack trace on standard error output error stream
                e.printStackTrace()
            }
        } else {
            // Exception is handled to check whether the camera resource is being used by another service or not
            try {
                // false sets the torch in OFF mode
                cameraManager!!.setTorchMode(getCameraID!!, false)

                // Inform the user about the flashlight status using Toast message
                Toast.makeText(this@MainActivity, "Flashlight is turned OFF", Toast.LENGTH_SHORT).show()
            } catch (e: CameraAccessException) {
                // Prints stack trace on standard error output error stream
                e.printStackTrace()
            }
        }
    }

    // When you click on the button and the torch opens and you do not close the torch again, this code will turn off the torch automatically
    @RequiresApi(Build.VERSION_CODES.M)
    override fun finish() {
        super.finish()
        try {
            // false sets the torch in OFF mode
            cameraManager!!.setTorchMode(getCameraID!!, false)

            // Inform the user about the flashlight status using Toast message
            Toast.makeText(this@MainActivity, "Flashlight is turned OFF", Toast.LENGTH_SHORT).show()
        } catch (e: CameraAccessException) {
            // Prints stack trace on standard error output error stream
            e.printStackTrace()
        }
    }
}
