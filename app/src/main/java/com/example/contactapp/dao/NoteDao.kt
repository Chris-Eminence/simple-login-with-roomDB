package com.example.contactapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.contactapp.entity.NoteEntity

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun selectAllNotes() : LiveData<List<NoteEntity>>

    @Insert
    fun insertNotes(noteEntity: NoteEntity)

    @Delete
    fun deleteNotes(noteEntity: NoteEntity)

    @Update
    fun updateNote(noteEntity: NoteEntity)

}