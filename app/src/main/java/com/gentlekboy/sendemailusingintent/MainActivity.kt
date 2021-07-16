package com.gentlekboy.sendemailusingintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declared variables for my buttons and intent
        val intent1 = Intent()
        val sendIntentButton = findViewById<Button>(R.id.sendMail)
        val viewIntentButton = findViewById<Button>(R.id.viewPDF)
        val nextButton = findViewById<Button>(R.id.nextPage)

        //This code block handles sending an email on click of the send button
        sendIntentButton.setOnClickListener {
            intent1.apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_EMAIL, arrayOf("kufreabasi.udoh@decagon.dev", "udoh.kufre.m@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "TESTING MY APPLICATION'S FUNCTIONALITY")
                putExtra(Intent.EXTRA_TEXT, "This is intent trial, it is working")
                type = "message/rfc822"
            }

            startActivity(Intent.createChooser(intent1, "Send mail with"))
        }

        //This code block handles viewing PDFs on click of the view button
        viewIntentButton.setOnClickListener {
            intent1.apply {
                action = Intent.ACTION_VIEW
                type = "application/pdf"
            }

            startActivity(Intent.createChooser(intent1, "Open with"))
        }

        //This code block navigates users into the second activity on click of the next button
        nextButton.setOnClickListener {
            val intent2 = Intent(this, SecondActivity::class.java)
            startActivity(intent2)
        }
    }
}