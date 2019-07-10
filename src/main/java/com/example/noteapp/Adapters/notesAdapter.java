package com.example.noteapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.noteapp.DataBase.Model.Note;
import com.example.noteapp.DataBase.NoteDataBase;
import com.example.noteapp.DataBase.NoteDataBase_Impl;
import com.example.noteapp.R;
import com.example.noteapp.helper.RecyclerItemTouchHelper;

import java.util.List;

public class notesAdapter extends RecyclerView.Adapter<notesAdapter.ViewHolder>   {

    List<Note>notes;

    public notesAdapter(List<Note> notes) {
        this.notes = notes;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view_note,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int pos) {

        Note note  = notes.get(pos);
        viewHolder.title.setText(note.getTitel());
        viewHolder.data.setText(note.getDate());

        if(onItemClickLisner!=null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickLisner.onItemClick(pos);
                }
            });
        }

        switch (note.getPirority()){
            case 1:{
                viewHolder.priorty.setText(R.string.high);
                viewHolder.priorty.setBackgroundResource(R.drawable.high_page);
                break;
            }
            case 2:{
                viewHolder.priorty.setText(R.string.normal);
                viewHolder.priorty.setBackgroundResource(R.drawable.normal_page);
                break;
            }
            case 3:{
                viewHolder.priorty.setText(R.string.low);
                viewHolder.priorty.setBackgroundResource(R.drawable.low_page);
                break;
            }
        }
        }


        public void changeData(List<Note>notes){
        this.notes=notes;
        notifyDataSetChanged();
        }




    @Override
    public int getItemCount() {
        if (notes==null)return 0;
        return notes.size();
    }

    public void removeItem(int pos){
        notes.remove(pos);
        notifyItemRemoved(pos);




    }

    public void restorItem(Note note,int pos){
        notes.add(pos,note);
        notifyItemInserted(pos);

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView data;
        TextView priorty;
        public RelativeLayout viewBackground , viewForeground;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            data = itemView.findViewById(R.id.dataa);
            priorty = itemView.findViewById(R.id.prioritty);


        }
    }
    onItemClickLisner onItemClickLisner;

    public void setOnItemClickListenet(notesAdapter.onItemClickLisner onItemClickListenet) {
        this.onItemClickLisner = onItemClickListenet;
    }


    public interface onItemClickLisner{
        void onItemClick(int pos);
    }
}
