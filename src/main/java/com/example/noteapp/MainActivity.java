package com.example.noteapp;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.noteapp.Adapters.notesAdapter;
import com.example.noteapp.DataBase.Model.Note;
import com.example.noteapp.DataBase.NoteDataBase;
import com.example.noteapp.helper.RecyclerItemTouchHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    notesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.Recycle_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        layoutManager = new LinearLayoutManager(this);
        adapter = new notesAdapter(null);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setOnItemClickListenet(new notesAdapter.onItemClickLisner() {
            @Override
            public void onItemClick(int pos) {
                Intent i = new Intent(MainActivity.this,NoteUpdata.class);
                i.putExtra("pos",pos);
                startActivity(i);
            }
        });









        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                startActivity(new Intent(MainActivity.this,AddNoteActivity.class));
            }
        });
        ItemTouchHelper.Callback callback = new RecyclerItemTouchHelper(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
    }


    @Override
    protected void onStart() {
        super.onStart();
        List<Note>notes =
                NoteDataBase.getInstance(this)
                .noteDAO()
                .getAllNote();
        adapter.changeData(notes);

    }

}
