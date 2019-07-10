package com.example.noteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.noteapp.DataBase.Model.Note;
import com.example.noteapp.DataBase.NoteDataBase;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText titel;
    protected EditText data;
    protected EditText deteals;
    protected Button addBtn;
    protected Spinner priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_add_note);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add_btn) {
            if (titel.getText() != null && data.getText() != null && deteals.getText() != null) {
                String stitel = titel.getText().toString();
                String sdata = data.getText().toString();
                String sdetals = deteals.getText().toString();
                int priorty = priority.getSelectedItemPosition()+1;
                Note note = new Note(stitel,sdetals,sdata,priorty);
                NoteDataBase.getInstance(this)
                        .noteDAO()
                        .InsertNote(note);
                finish();

            } else{
                Toast.makeText(this, "please enter all data", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void initView() {
        titel = (EditText) findViewById(R.id.titel);
        data = (EditText) findViewById(R.id.data);
        deteals = (EditText) findViewById(R.id.deteals);
        addBtn = (Button) findViewById(R.id.add_btn);
        addBtn.setOnClickListener(AddNoteActivity.this);
        priority = (Spinner) findViewById(R.id.priority);
    }
}
