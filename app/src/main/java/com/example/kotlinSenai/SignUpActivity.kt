package com.example.kotlinSenai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        val edtRegUser = findViewById<EditText>(R.id.edtRegUser)
        val edtRegPass = findViewById<EditText>(R.id.edtRegPass)

        btnSignUp.setOnClickListener {
            if (edtRegUser.text.toString().isEmpty() || edtRegPass.text.toString().isEmpty()){
                Toast.makeText(
                    this,
                    "Coloque um usuário e senha",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else{
                val email: String = edtRegUser.text.toString().trim{ it <= ' '}
                val password: String = edtRegPass.text.toString().trim{ it <= ' '}

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                        OnCompleteListener { task ->

                            if (task.isSuccessful) {


                                val firebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(
                                    this,
                                    "Cadastro concluído.",
                                    Toast.LENGTH_LONG
                                ).show()

                                val intent = Intent(this,MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            else{
                                Toast.makeText(
                                    this,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    )
            }



            }
        }
    }
