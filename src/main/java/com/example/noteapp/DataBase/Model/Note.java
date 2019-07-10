package com.example.noteapp.DataBase.Model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Note {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo
    String titel;
    @ColumnInfo (name = "Content")
    String desc;
    @ColumnInfo
    String date;
    @ColumnInfo
    int pirority;// لتوضيح اهمية الnote

    public Note() {
    }

    @Ignore
    public Note(String titel, String desc, String date, int pirority) {
        this.titel = titel;
        this.desc = desc;
        this.date = date;
        this.pirority = pirority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPirority() {
        return pirority;
    }

    public void setPirority(int pirority) {
        this.pirority = pirority;
    }
}
