package com.example.app1
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.app1.R
import com.example.app1.databinding.ActivityMainBinding

private const val REQUEST_CODE = 100
class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    private lateinit var firstNameText: EditText
    private lateinit var lastNameText: EditText
    private lateinit var imageView: ImageView
    private var imageBitmap: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val homePageOpen = findViewById<Button>(R.id.submit_button)
        val takeImg = findViewById<Button>(R.id.img_take)
        imageView = findViewById(R.id.imageView)
        firstNameText = findViewById(R.id.name_text)
        lastNameText = findViewById(R.id.lastName_text)
        homePageOpen.setOnClickListener {
            startActivity(Intent(this, NextPageActivity::class.java).putExtra("firstName", firstNameText.text.toString()).putExtra("lastName", lastNameText.text.toString()))
        }
        takeImg.setOnClickListener {
            val takeImgIntent = Intent("android.media.action.IMAGE_CAPTURE")
            startActivityForResult(takeImgIntent, 100)

        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE) {
            imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("imageBitmap", imageBitmap)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        imageBitmap = savedInstanceState?.getParcelable<Bitmap>("imageBitmap")
        imageView.setImageBitmap(imageBitmap)
    }
}