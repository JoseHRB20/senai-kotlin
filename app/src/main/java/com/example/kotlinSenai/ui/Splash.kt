package com.example.kotlinSenai.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.kotlinSenai.MainActivity
import com.example.kotlinSenai.R

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var senaiLogo = findViewById<ImageView>(R.id.senaiLogo)

        senaiLogo.alpha =0f
        senaiLogo.animate().setDuration(1800).alpha(1f).withEndAction {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }





    }
}