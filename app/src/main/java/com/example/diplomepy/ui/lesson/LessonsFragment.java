package com.example.diplomepy.ui.lesson;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomepy.R;
import com.example.diplomepy.ui.lesson.adapter.LessonRecyclerViewAdapter;


public class LessonsFragment extends Fragment {

   private RecyclerView recyclerView;
   private LessonRecyclerViewAdapter lessonRecyclerViewAdapter;

   private LessonsViewModel lessonsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lesson, container, false);

       int  id = getArguments().getInt("id", 0);

        lessonsViewModel = new ViewModelProvider(this, new LessonsViewModelFactory(getActivity().getApplication(), id)).get(LessonsViewModel.class);

        lessonRecyclerViewAdapter = new LessonRecyclerViewAdapter();

        recyclerView = root.findViewById(R.id.list_lesson);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(lessonRecyclerViewAdapter);


        root.findViewById(R.id.go_question).setOnClickListener(view -> {
            Bundle bundle = new Bundle();

            bundle.putInt("id", id);

            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
            navController.navigate(R.id.nav_question, bundle);
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lessonsViewModel.getLessonList().observe(getViewLifecycleOwner(), baseModels -> {
            lessonRecyclerViewAdapter.setList(baseModels);
        });

    }

}
