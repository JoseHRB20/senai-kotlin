package com.example.kotlinSenai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.kotlinSenai.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnSignIn = findViewById<Button>(R.id.btnSignIn)
        val txtSignUp = findViewById<TextView>(R.id.txtSignUp)
        val edtUser = findViewById<EditText>(R.id.edtUser)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)

        btnSignIn.setOnClickListener {
            if (edtUser.text.toString().isEmpty() || edtPassword.text.toString().isEmpty()) {
                Toast.makeText(
                    this,
                    "Coloque um usuário e senha",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val email: String = edtUser.text.toString().trim { it <= ' ' }
                val password: String = edtPassword.text.toString().trim { it <= ' ' }

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                        OnCompleteListener { task ->

                            if (task.isSuccessful) {

                                Toast.makeText(
                                    this,
                                    "Voçê está logado.",
                                    Toast.LENGTH_LONG
                                ).show()

                                val intent = Intent(this, DrawerActivity::class.java)
                                intent.putExtra(
                                    "user_id",
                                    FirebaseAuth.getInstance().currentUser!!.uid
                                )
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        })
            }
        }

        txtSignUp.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)

        }
    }
}