package com.example.contactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun friendsCategory(view: View) {
        intent = Intent(this, FriendsCategory::class.java)
        startActivity(intent)
    }
    fun familyCategory(view: View) {
        intent = Intent(this, FamilyCategory::class.java)
        startActivity(intent)
    }
    fun workCategory(view: View) {
        intent = Intent(this, WorkCategory::class.java)
        startActivity(intent)
    }
    fun mentorsCategory(view: View) {
        intent = Intent(this, MentorsCategory::class.java)
        startActivity(intent)
    }
}