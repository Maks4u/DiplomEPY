package com.example.diplomepy.ui.glossary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomepy.R;
import com.example.diplomepy.databse.entities.DictModel;

import java.util.ArrayList;
import java.util.List;

public class DictAdapter extends RecyclerView.Adapter<DictAdapter.NoteHolder> implements Filterable {

    private List<DictModel> notesFiltered;
    private List<DictModel> notesFull;

    private final OnItemClick onItemClick;

    DictAdapter(final OnItemClick onItemClick, final List<DictModel> list) {
        notesFull = list;
        notesFiltered = new ArrayList<>(notesFull);
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_dict, parent, false);
        return new NoteHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        DictModel currentNote = notesFiltered.get(position);
        holder.textViewTitle.setText(currentNote.getTitle());
        holder.textViewDescription.setText(currentNote.getInformation());
    }

    DictModel getNoteAt(int position) {
        return notesFiltered.get(position);
    }

    @Override
    public int getItemCount() {
        return notesFiltered.size();
    }

    void setFilter(String text){
        filter.filter(text);
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<DictModel> filteredDict = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredDict.addAll(notesFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (DictModel item : notesFull) {
                    if (item.getTitle().toLowerCase().contains(filterPattern) || item.getInformation().toLowerCase().contains(filterPattern)) {
                        filteredDict.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredDict;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            notesFiltered.clear();
            notesFiltered.addAll((List) results.values);
            notifyDataSetChanged();
        }

    };

    class NoteHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textViewTitle;
        private TextView textViewDescription;

        NoteHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.title_dict);
            textViewDescription = itemView.findViewById(R.id.text_view_description);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onItemClick.itemClick( notesFiltered.get(getAdapterPosition()));
        }
    }

    public interface OnItemClick{

        void itemClick(final DictModel dict);
    }
}
