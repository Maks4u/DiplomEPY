package com.example.diplomepy.ui.question.adapterViewFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.diplomepy.R;
import com.example.diplomepy.ui.question.adapter.AnswerAdapter;
import com.example.diplomepy.ui.question.dialogs.AlertDialogFalse;
import com.example.diplomepy.ui.question.dialogs.AlertDialogTrue;

public class ArrayListFragment extends Fragment implements AnswerAdapter.OnItemClick {

    private TextView textView;

    private ArrayListViewModel arrayListViewModel;
    private AnswerAdapter answerAdapter;
    private RecyclerView recyclerView;
    private final AlertDialogTrue alertDialogTrue = new AlertDialogTrue();
    private final AlertDialogFalse alertDialogFalse = new AlertDialogFalse();

    public static ArrayListFragment newInstance(int someInt) {
        ArrayListFragment myFragment = new ArrayListFragment();

        Bundle args = new Bundle();
        args.putInt("id", someInt);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragmet_test, container, false);

        answerAdapter = new AnswerAdapter(this);

        textView = root.findViewById(R.id.question_text_view);
        recyclerView = root.findViewById(R.id.question_answers);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setHasFixedSize(true);

        int id= getArguments().getInt("id", 0);

        arrayListViewModel =  new ViewModelProvider(this, new ArrayListViewModelFactory(requireActivity().getApplication(), id)).get(ArrayListViewModel.class);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arrayListViewModel.getQuestion().observe(getViewLifecycleOwner(), questionTestModel -> textView.setText(questionTestModel.getQuestion()));

        arrayListViewModel.getAnswersList().observe(getViewLifecycleOwner(), answerTestModels -> {
            answerAdapter.setList(answerTestModels);
            recyclerView.setAdapter(answerAdapter);
        });

        arrayListViewModel.getCorrect().observe(getViewLifecycleOwner(), aBoolean -> {
            if(aBoolean){
                arrayListViewModel.checkAnswers();
            }else {
                alertDialogFalse.show(getChildFragmentManager(), "some_text");
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigateUp();
            }

        });

        arrayListViewModel.getAnswer().observe(getViewLifecycleOwner(), answersUpgrades -> answerAdapter.setList(answersUpgrades));

        arrayListViewModel.getSuccess().observe(getViewLifecycleOwner(), aBoolean -> {
            alertDialogTrue.show(getChildFragmentManager(), "some_text");
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigateUp();
        });

    }

    @Override
    public void itemClick(int id) {
        arrayListViewModel.setCheckCorrect(id);
    }
}
