package com.example.diplomepy.ui.lesson.adapter.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomepy.R;

public class TextViewHolder extends RecyclerView.ViewHolder {

    public TextView textLesson;

    public TextViewHolder(@NonNull View itemView) {
        super(itemView);

        textLesson = itemView.findViewById(R.id.text_view_holder);

    }

}
