package com.example.myresumeapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var small_photo: ImageView
    private lateinit var phone_number: TextView
    private lateinit var resume_text: TextView
    private lateinit var mail_text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        small_photo = findViewById(R.id.resume_photo)
        phone_number = findViewById(R.id.text_number_phone)
        resume_text = findViewById(R.id.resume_short_info)
        mail_text = findViewById(R.id.text_mail)

        small_photo.setOnClickListener {
            val intent: Intent = Intent(this, BigResumePhotoActivity::class.java)
            startActivity(intent)
        }

        phone_number.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:" +  phone_number.text.toString())
            startActivity(callIntent)
        }

        resume_text.setOnClickListener {
            val intent: Intent = Intent(this, FullResumeActivity::class.java)
            startActivity(intent)
        }

        mail_text.setOnClickListener {
            val intent: Intent = Intent(this, MailActivity::class.java)
            startActivity(intent)
        }
    }
}