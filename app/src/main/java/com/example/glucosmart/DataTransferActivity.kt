package com.example.glucosmart

import android.Manifest.permission.BLUETOOTH
import android.Manifest.permission.BLUETOOTH_ADMIN
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import java.util.*
import android.Manifest
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_data_transfer.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.ChoiceFormat.nextDouble
import kotlin.random.Random.Default.nextDouble


class DataTransferActivity : AppCompatActivity() {

//    private val adapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
//    private lateinit var socket: BluetoothSocket
//    private lateinit var device: BluetoothDevice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_transfer)

        Handler(Looper.getMainLooper()).postDelayed({
            changeTextViewValue(tv_temp, 32.5, 20, 800L)
        }, 1000)





        btn_pdf.setOnClickListener {
            val intent = Intent(this@DataTransferActivity, PDFActivity::class.java)
        startActivity(intent)
        }

//
//    @SuppressLint("MissingPermission")
//    fun receiveData(deviceName: String, context: Context): String {
//        if (!checkBluetoothPermissions(context)) {
//            // Handle the case where the user has not granted the necessary permissions
//            return "Bluetooth permissions not granted"
//        } else {
//
//            if (!adapter.isEnabled) {
//                // turn on Bluetooth if it's off
//                adapter.enable()
//            }
//
//            device = adapter.getRemoteDevice(deviceName)
//            socket =
//                device.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"))
//
//            // Connect to the remote device
//            socket.connect()
//
//            // Get the input stream and read the data
//            val inputStream = socket.inputStream
//            val inputReader = BufferedReader(InputStreamReader(inputStream))
//            return inputReader.readLine()
//        }
//    }
//
//    private fun checkBluetoothPermissions(context: Context): Boolean {
//        return ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH) == PackageManager.PERMISSION_GRANTED
//                && ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_ADMIN) == PackageManager.PERMISSION_GRANTED
//    }
    }


    fun changeTextViewValue(textView: TextView, finalValue: Double, stepCount: Int, interval: Long) {
        var currentValue = 27.6
        val stepSize = (finalValue - currentValue) / stepCount
        val handler = Handler()
        val runnable = object : Runnable {
            var count = 0
            override fun run() {
                if (count < stepCount) {
                    count++
                    currentValue += stepSize
                    textView.text = "%.2fC".format(currentValue)
                    handler.postDelayed(this, interval)
                }
            }
        }
        handler.postDelayed(runnable, interval)
    }
}
