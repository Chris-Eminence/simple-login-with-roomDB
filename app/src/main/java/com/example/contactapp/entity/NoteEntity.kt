package com.example.contactapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity (
    @PrimaryKey(autoGenerate = true)

    var id : Int = 0,
    var emailAddressID : String,
    var passwordDescription : String
)