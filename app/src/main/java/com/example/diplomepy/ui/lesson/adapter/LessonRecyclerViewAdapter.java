package com.example.diplomepy.ui.lesson.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.diplomepy.R;
import com.example.diplomepy.databse.entities.BaseModel;
import com.example.diplomepy.databse.entities.ImageTestModel;
import com.example.diplomepy.databse.entities.TextTestModel;
import com.example.diplomepy.ui.lesson.adapter.viewHolders.ImageViewHolder;
import com.example.diplomepy.ui.lesson.adapter.viewHolders.TextViewHolder;

import java.util.ArrayList;
import java.util.List;

public class LessonRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TEXT_VIEW = 0;
    private static final int IMG_VIEW = 1;

    private List<BaseModel> list = new ArrayList<>();

    public void setList(final List<BaseModel> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TEXT_VIEW) {
            View layoutInflaterText = LayoutInflater.from(parent.getContext()).inflate(R.layout.text, parent, false);
            return new TextViewHolder(layoutInflaterText);
        }else {
            View layoutInflaterText = LayoutInflater.from(parent.getContext()).inflate(R.layout.image, parent, false);
            return new ImageViewHolder(layoutInflaterText);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position) instanceof ImageTestModel){
            return IMG_VIEW;
        }else {
            return TEXT_VIEW;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if ( holder.getItemViewType() == IMG_VIEW ){
            ImageTestModel baseModel = (ImageTestModel) list.get(position);
            ImageViewHolder imageViewHolder = (ImageViewHolder) holder;

            Glide.with(imageViewHolder.imageView.getContext())
                    .load(baseModel.getPicture())
                    .into(imageViewHolder.imageView);
        }else {
            TextTestModel baseModel = (TextTestModel) list.get(position);
            TextViewHolder textViewHolder = (TextViewHolder) holder;
            textViewHolder.textLesson.setText(baseModel.getText());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
