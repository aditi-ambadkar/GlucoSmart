package com.example.glucosmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        btn_reading.setOnClickListener {
            val intent = Intent(this@HomeActivity, DataTransferActivity::class.java)
            startActivity(intent)
        }
    }
}