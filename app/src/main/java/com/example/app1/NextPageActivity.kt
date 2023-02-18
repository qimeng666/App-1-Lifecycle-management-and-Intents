package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.app1.R

class NextPageActivity : AppCompatActivity() {
    private lateinit var textName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_page)

        textName = findViewById(R.id.welcome_text)
        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        textName.text = firstName + "  " + lastName + " is logged in!"
    }
}