package com.example.myresumeapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MailActivity : AppCompatActivity() {
    private lateinit var my_mail: EditText
    private lateinit var subject: EditText
    private lateinit var my_message: EditText
    private lateinit var send_button: Button
    private lateinit var cross_img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail)

        my_mail = findViewById(R.id.my_mail)
        subject = findViewById(R.id.subject)
        my_message = findViewById(R.id.my_message)
        send_button = findViewById(R.id.send_button)
        cross_img = findViewById(R.id.cross)

        cross_img.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        send_button.setOnClickListener {
            val emailsend = my_mail.getText().toString()
            val emailsubject = subject.getText().toString()
            val emailbody = my_message.getText().toString()

            val mailIntent = Intent(Intent.ACTION_SEND)
            intent.setData(Uri.parse("mailto:"))
            mailIntent.setType("text/plain");

            mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(emailsend))
            mailIntent.putExtra(Intent.EXTRA_SUBJECT, emailsubject)
            mailIntent.putExtra(Intent.EXTRA_TEXT, emailbody)
            mailIntent.setType("message/rfc822");
            try {
                startActivity(Intent.createChooser(mailIntent, "Choose an Email client :"));
                Log.i("Finished sending email...", "")
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}