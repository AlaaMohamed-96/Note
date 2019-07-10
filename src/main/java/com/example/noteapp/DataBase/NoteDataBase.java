package com.example.noteapp.DataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.noteapp.DataBase.Model.DAOs.NoteDAO;
import com.example.noteapp.DataBase.Model.Note;


@Database(entities = {Note.class},version = 1,exportSchema = false)
public abstract class NoteDataBase extends RoomDatabase {



    private static final String DATABASE_NAME = "noteDataBase";
    private static NoteDataBase dataBase;
    public abstract NoteDAO noteDAO();

    public static NoteDataBase getInstance(Context context){
        if (dataBase==null){
            dataBase= Room.databaseBuilder(context,
                    NoteDataBase.class,
                    DATABASE_NAME
                    )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return dataBase;
    }
}
