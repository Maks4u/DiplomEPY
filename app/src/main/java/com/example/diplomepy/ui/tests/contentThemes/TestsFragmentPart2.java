package com.example.diplomepy.ui.tests.contentThemes;

import android.content.Context;
import android.os.Bundle;
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
import com.example.diplomepy.ui.question.Singleton;

public class TestsFragmentPart2 extends Fragment implements MainAdapterPart2.OnItemClick {


    private int prent_id;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(getArguments() != null)
        prent_id = getArguments().getInt("id", 0);
    }

    private MainViewModelPart2 mainViewModelPart2;
    private MainAdapterPart2 adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_test_part2, container, false);
        mainViewModelPart2 = new ViewModelProvider(this, new MainViewModelFactory(prent_id, requireActivity().getApplication())).get(MainViewModelPart2.class);

        RecyclerView recyclerView = root.findViewById(R.id.mainTestPart2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        adapter = new MainAdapterPart2(this);
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       mainViewModelPart2.getAllTestsPart2().observe(getViewLifecycleOwner(), mainTests -> {
            adapter.setNotes(mainTests);
            Singleton.getInstance().setListPart2(mainTests);
        });
    }

    @Override
    public void itemClick(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);

        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.nav_lesson, bundle);
    }

    @Override
    public void adapterListPos(int pos) {
        Singleton.getInstance().setCurrentTestId(pos);
    }
}
