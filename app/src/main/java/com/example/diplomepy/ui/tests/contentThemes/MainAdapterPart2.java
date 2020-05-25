package com.example.diplomepy.ui.tests.contentThemes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomepy.R;
import com.example.diplomepy.databse.entities.MainTestPart2;

import java.util.ArrayList;
import java.util.List;

public class MainAdapterPart2 extends RecyclerView.Adapter<MainAdapterPart2.NoteHolder> {

    private List<MainTestPart2> notes = new ArrayList<>();
    private static final int CLICKABLE_YES = 1;
    private static final int CLICKABLE_NO = 0;
    private final MainAdapterPart2.OnItemClick onItemClick;

    MainAdapterPart2(final MainAdapterPart2.OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == CLICKABLE_YES) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.button_test_part2, parent, false);
            return new NoteHolder(itemView, CLICKABLE_YES);
        } else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.button_test_part2_no_active, parent, false);
            return new NoteHolder(itemView, CLICKABLE_NO);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        MainTestPart2 currentNote = notes.get(position);
        holder.textViewTitle.setText(currentNote.getName_lesson());

    }

    @Override
    public int getItemViewType(int position) {

        if (notes.get(position).getBlocked() == 1) {
            return CLICKABLE_YES;
        } else {
            return CLICKABLE_NO;
        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    void setNotes(List<MainTestPart2> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textViewTitle;

        NoteHolder(View itemView, int clickable) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_test_nav_v2);

            if (clickable == CLICKABLE_YES) {
                itemView.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View v) {
            onItemClick.itemClick(notes.get(getAdapterPosition()).getId_lesson());
            onItemClick.adapterListPos(getAdapterPosition());
        }
    }


    public interface OnItemClick {
        void itemClick(int id);

        void adapterListPos(int pos);
    }
}
