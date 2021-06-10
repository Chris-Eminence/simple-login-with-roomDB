package com.example.contactapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.contactapp.entity.NoteEntity
import com.example.contactapp.entity.NoteRepository

class SignUp : AppCompatActivity() {
    lateinit var noteRepository: NoteRepository
    lateinit var emailAddressEditText: EditText
    lateinit var confirmedPasswordEditText: EditText
    lateinit var initialPasswordET: EditText
    lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        init()
    }

    fun init() {

        noteRepository = NoteRepository(this)
        noteRepository.getAllNotes()

        emailAddressEditText = findViewById(R.id.email_address_edit_text)
        initialPasswordET = findViewById(R.id.password_edit_text)
        confirmedPasswordEditText = findViewById(R.id.confirm_password_edit_text)
        signUpButton = findViewById(R.id.register_button)

        signUpButton.setOnClickListener {
//            if (initialPasswordET == confirmedPasswordEditText) {
                saveEntry()
                val intent = Intent(this, Login::class.java)
                startActivity(intent)

        //}else{
//
//                Toast.makeText(this, "Password mismatched", Toast.LENGTH_SHORT).show()
            }
  //      }

    }

    fun saveEntry() {
        if (emailAddressEditText.text.isNullOrBlank() || confirmedPasswordEditText.text.isNullOrBlank()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
        } else {
            val note = NoteEntity(emailAddressID = emailAddressEditText.text.toString(), passwordDescription = confirmedPasswordEditText.text.toString())
            noteRepository.insertNote(note)
            finish()
        }

    }
}