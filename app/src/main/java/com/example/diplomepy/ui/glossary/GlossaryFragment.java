package com.example.diplomepy.ui.glossary;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomepy.R;
import com.example.diplomepy.databse.entities.DictModel;


public class GlossaryFragment extends Fragment implements DictAdapter.OnItemClick {

    private DictViewModel dictViewModel;
    private DictAdapter dictAdapter;
    private ImageButton addDict;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_glossary, container, false);
        dictViewModel = new ViewModelProvider(this).get(DictViewModel.class);

        addDict = root.findViewById(R.id.add_dict);

        recyclerView = root.findViewById(R.id.text_glo);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        SearchView searchView = root.findViewById(R.id.search_text);
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnClickListener(v -> searchView.setIconified(false));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                dictAdapter.setFilter(newText);
                return false;
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                dictViewModel.delete(dictAdapter.getNoteAt(viewHolder.getAdapterPosition()));
                Toast.makeText(getContext(), "Термін видалено", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dictViewModel.getAllDict().observe(getViewLifecycleOwner(), mainTests -> {
            dictAdapter = new DictAdapter(this, mainTests);
            recyclerView.setAdapter(dictAdapter);
        });


        addDict.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
            navController.navigate(R.id.action_nav_glossary_to_addEditDictFragment);
        });

    }

    @Override
    public void itemClick(final DictModel dict) {

        Bundle bundle = new Bundle();
        bundle.putParcelable("model", dict);

        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.action_nav_glossary_to_addEditDictFragment, bundle);

    }
}
