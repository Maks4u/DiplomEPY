package com.example.diplomepy.ui.glossary.addEditDictionary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diplomepy.R;
import com.example.diplomepy.databse.entities.DictModel;

public class AddEditDictFragment extends Fragment {

    private AddEditDictViewModel addEditDictViewModel;

    private EditText editTextTitle;
    private EditText editTextDescription;
    private CardView saveButton;

    private DictModel dictModel = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_add_dict, container, false);

        addEditDictViewModel = new ViewModelProvider(this).get(AddEditDictViewModel.class);

        editTextTitle = root.findViewById(R.id.edit_text_title);
        editTextDescription = root.findViewById(R.id.edit_text_description);
        saveButton = root.findViewById(R.id.save_dict);

        if (getArguments() != null) {
            dictModel = getArguments().getParcelable("model");
            editTextTitle.setText(dictModel.getTitle());
            editTextDescription.setText(dictModel.getInformation());
        }

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        saveButton.setOnClickListener(v -> {

            if (dictModel != null) {
                DictModel editedDictModel = new DictModel(editTextTitle.getText().toString(), editTextDescription.getText().toString());
                editedDictModel.setId_dict(dictModel.getId_dict());
                addEditDictViewModel.updateDict(editedDictModel);
            } else {
                addEditDictViewModel.addDict(new DictModel(editTextTitle.getText().toString(), editTextDescription.getText().toString()));
            }

        });

        addEditDictViewModel.getSuccess().observe(getViewLifecycleOwner(), s -> {
            Toast.makeText(requireContext(), s, Toast.LENGTH_SHORT).show();
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigateUp();
        });

        addEditDictViewModel.gerError().observe(getViewLifecycleOwner(), s -> {
            Toast.makeText(requireContext(), s, Toast.LENGTH_SHORT).show();
        });

    }

}
