package com.example.myresumeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class BigResumePhotoActivity : AppCompatActivity() {

    private lateinit var big_photo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_resume_photo)

        big_photo = findViewById(R.id.bigPhoto)

        big_photo.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}