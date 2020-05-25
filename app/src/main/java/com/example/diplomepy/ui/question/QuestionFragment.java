package com.example.diplomepy.ui.question;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.diplomepy.R;
import com.example.diplomepy.ui.question.adapter.QuestionAdapter;

public class QuestionFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_question, container, false);
        QuestionAdapter questionAdapter = new QuestionAdapter(requireActivity());
        ViewPager2 viewPager2 = root.findViewById(R.id.view_pager_test);

        QuestionViewModel questionViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        int id = getArguments().getInt("id");

        questionViewModel.getAllQuestions(id).observe(getViewLifecycleOwner(), questionTestModels -> {
            questionAdapter.setCount(  questionTestModels.size());
            viewPager2.setAdapter(questionAdapter);
            Singleton.getInstance().setListQuestions(questionTestModels);
        });

        return root;
    }
}
