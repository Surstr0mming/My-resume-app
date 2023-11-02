package com.example.myresumeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class FullResumeActivity : AppCompatActivity() {

    private lateinit var full_resume: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_resume)

        full_resume = findViewById(R.id.full_resume_photo)

        full_resume.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}