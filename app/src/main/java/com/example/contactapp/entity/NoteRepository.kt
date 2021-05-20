package com.example.contactapp.entity

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NoteRepository(context: Context){
   private val db = NoteDatabase.invoke(context)

    fun getAllNotes() : LiveData<List<NoteEntity>> = db.noteDao().selectAllNotes()

    fun insertNote(noteEntity: NoteEntity){
        GlobalScope.launch {
            db.noteDao().insertNotes(noteEntity)
        }
    }
}