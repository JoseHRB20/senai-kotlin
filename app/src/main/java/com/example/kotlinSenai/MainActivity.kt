package com.example.kotlinSenai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.firstapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val btnNome = findViewById<Button>(R.id.btnNome)
        val textViewNome = findViewById<TextView>(R.id.textViewNome)
        val edtNome = findViewById<EditText>(R.id.edtNome)

        btnNome.setOnClickListener {
            if (edtNome.text.isNotBlank()) {
                textViewNome.text = edtNome.text.toString()
            } else {
                textViewNome.text = "Digite um nome abaixo"
            }
        }

        btnEnviar.setOnClickListener {
            if (edtNome.text.isNotBlank()) {
                val nomeDigitado = edtNome.text.toString()
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("NOME_DIGITADO", nomeDigitado)
                startActivity(intent)
            } else {
                textViewNome.text = "Digite um nome abaixo"
            }
        }
    }
}