package com.example.diplomepy.ui.tests.themes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomepy.R;
import com.example.diplomepy.models.CombinedModel;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.NoteHolder> {

    private List<CombinedModel> notes = new ArrayList<>();
    private static final int CLICKABLE_YES = 1;
    private static final int CLICKABLE_NO = 0;
    private final OnItemClick onItemClick;

    MainAdapter(final OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == CLICKABLE_YES) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.button_test, parent, false);
            return new NoteHolder(itemView, CLICKABLE_YES);
        }else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.button_test_no_active, parent, false);
            return new NoteHolder(itemView, CLICKABLE_NO);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        CombinedModel currentNote = notes.get(position);
        holder.textViewTitle.setText(currentNote.getName());
        holder.textViewDescription.setText(currentNote.getCounter() + "/" + currentNote.getCount());
    }

    @Override
    public int getItemViewType(int position) {

        if(notes.get(position).getBlocked() == 1){
            return CLICKABLE_YES;
        }else {
            return CLICKABLE_NO;
        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    void setNotes(List<CombinedModel> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textViewTitle;
        private TextView textViewDescription;

        NoteHolder(View itemView, int clickable) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_test_nav);
            textViewDescription = itemView.findViewById(R.id.text_description);

            if (clickable == CLICKABLE_YES) {
                itemView.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View v) {
            onItemClick.itemClick( notes.get(getAdapterPosition()).getId_main(), getAdapterPosition());
        }
    }

    public interface OnItemClick{
        void itemClick(int id, int positionInArray);
    }

}
