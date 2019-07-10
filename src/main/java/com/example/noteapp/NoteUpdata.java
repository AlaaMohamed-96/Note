package com.example.noteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.noteapp.DataBase.Model.Note;
import com.example.noteapp.DataBase.NoteDataBase;

import java.util.List;

public class NoteUpdata extends AppCompatActivity implements View.OnClickListener {
    protected EditText titel;
    protected EditText data;
    protected EditText deteals;
    protected Spinner priority;
    protected Button updateBtn;
    int intentPos;

    List<Note> notes = NoteDataBase.getInstance(this)
            .noteDAO()
            .getAllNote();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_note_updata);
        intentPos = getIntent().getIntExtra("pos", -1);
        initView();
        Note note = notes.get(intentPos);
        titel.setText(note.getTitel());
        data.setText(note.getDate());
        deteals.setText(note.getDesc());



    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.update_btn) {
            String stitel = titel.getText().toString();
            String sdata = data.getText().toString();
            String sdetals = deteals.getText().toString();
            int priorty = priority.getSelectedItemPosition()+1;
             Note note = notes.get(intentPos);
             note.setDate(sdata);
             note.setDesc(sdetals);
             note.setPirority(priorty);
             note.setTitel(stitel);
            NoteDataBase.getInstance(this)
                    .noteDAO()
                    .UpdateNote(note);
            finish();

        }
    }

    private void initView() {
        titel = (EditText) findViewById(R.id.titel);
        data = (EditText) findViewById(R.id.data);
        deteals = (EditText) findViewById(R.id.deteals);
        priority = (Spinner) findViewById(R.id.priority);
        updateBtn = (Button) findViewById(R.id.update_btn);
        updateBtn.setOnClickListener(NoteUpdata.this);
    }
}
