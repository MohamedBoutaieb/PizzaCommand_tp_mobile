package com.gl4.pizzacommand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        img = findViewById<View>(R.id.InsatLogo) as ImageView
        // img.setImageResource(android.R.drawable.stat_sys_upload_done)
        val handler = Handler()
        handler.postDelayed({
            returnHome()
        }, 3000)
    }

    fun returnHome() {

        val intent = Intent(img.context, MainActivity::class.java)
        startActivity(intent)
    }

}