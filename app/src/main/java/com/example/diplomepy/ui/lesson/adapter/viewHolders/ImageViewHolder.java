package com.example.diplomepy.ui.lesson.adapter.viewHolders;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomepy.R;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;

    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_view_holder);
    }

}
