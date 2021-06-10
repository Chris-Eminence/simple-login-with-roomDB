package com.example.contactapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.contactapp.entity.NoteEntity
import com.example.contactapp.entity.NoteRepository

class Login : AppCompatActivity() {

    lateinit var emailAddressLoginEditText: EditText
    lateinit var passwordLoginEditText: EditText
    lateinit var loginButton: Button
    lateinit var noteRepository: NoteRepository
    lateinit var noteEntity: NoteEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailAddressLoginEditText = findViewById(R.id.email_login_edit_text)
        passwordLoginEditText = findViewById(R.id.login_password)
        loginButton = findViewById(R.id.login_button)

        loginButton.setOnClickListener {
            if (noteEntity.emailAddressID == emailAddressLoginEditText.text.toString() && noteEntity.passwordDescription == passwordLoginEditText.text.toString()){
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Account not found", Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun authenticateCredentials() {
    }
}