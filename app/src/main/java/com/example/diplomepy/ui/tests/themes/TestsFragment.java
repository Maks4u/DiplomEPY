package com.example.diplomepy.ui.tests.themes;

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
import com.example.diplomepy.ui.question.Singleton;

public class TestsFragment extends Fragment implements MainAdapter.OnItemClick {

    private MainViewModel mainViewModel;
    private MainAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_test, container, false);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        RecyclerView recyclerView = root.findViewById(R.id.mainTest);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        adapter = new MainAdapter(this);
        recyclerView.setAdapter(adapter);

        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainViewModel.getAllTests().observe(getViewLifecycleOwner(), mainTests -> {
            Singleton.getInstance().setMainTestList(mainTests);
            mainViewModel.mapper(mainTests).observe(getViewLifecycleOwner(), combinedModels -> {
                adapter.setNotes(combinedModels);
            });
        });

    }

    @Override
    public void itemClick(int id, int arrayPosition) {

        Bundle bundle = new Bundle();
        bundle.putInt("id", id);

        Singleton.getInstance().setTestMainPosition(arrayPosition);

         NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
         navController.navigate(R.id.nav_test_part2, bundle);
    }


}



