package com.example.noteapp.DataBase.Model.DAOs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.noteapp.DataBase.Model.Note;

import java.util.List;

@Dao
public interface NoteDAO {

    @Insert
    void InsertNote(Note note);
    @Update
    void UpdateNote(Note note);
    @Delete
    void DeleteNote(Note note);

    @Query("delete from note where titel=:titel")
    void DeleteNoteByTitiel(String titel);

    @Query("select * from note")
    List<Note>getAllNote();

    @Query("select * from note where titel=:Titel")
    List<Note>SearchNoteByTitel(String Titel);


}
