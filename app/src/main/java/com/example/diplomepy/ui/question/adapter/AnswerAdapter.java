package com.example.diplomepy.ui.question.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomepy.R;
import com.example.diplomepy.databse.entities.AnswerTestModel;
import com.example.diplomepy.models.AnswersUpgrade;

import java.util.ArrayList;
import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder> {

    private List<AnswerTestModel> notes = new ArrayList<>();
    private final OnItemClick onItemClick;
    private static final int WORKING_ANSWER = 0;
    private static final int NOT_WORKING_ANSWER = 1;

    public AnswerAdapter(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public void setList(List<AnswerTestModel> models) {
        notes = models;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(notes.get(position).getCorrectAnswer() == 1){
            return NOT_WORKING_ANSWER;
        }else {
            return WORKING_ANSWER;
        }
    }

    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == WORKING_ANSWER) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.answer_button, parent, false);
            return new AnswerViewHolder(itemView, WORKING_ANSWER);
        }else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.answer__button_true, parent, false);
            return new AnswerViewHolder(itemView, NOT_WORKING_ANSWER);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerViewHolder holder, int position) {
        AnswerTestModel currentNote = notes.get(position);
        holder.textAnswer.setText(currentNote.getAnswer());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }


    class AnswerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textAnswer;

        public AnswerViewHolder(@NonNull View itemView, int position) {
            super(itemView);
            textAnswer = itemView.findViewById(R.id.answer_button);


            if (position == WORKING_ANSWER) {
                itemView.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View v) {
            onItemClick.itemClick(getAdapterPosition());
        }
    }

    public interface OnItemClick {
        void itemClick(int correct);
    }
}
