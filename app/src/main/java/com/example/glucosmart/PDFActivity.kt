package com.example.glucosmart

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView
import kotlinx.android.synthetic.main.activity_pdfactivity.*

class PDFActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdfactivity)

        val pdfUrl = "https://drive.google.com/uc?export=download&id=15vaE5puIAq3HCtOnX3KjA1L23dfee1ug"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(Uri.parse(pdfUrl), "application/pdf")
        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
        startActivity(intent)

    }
}