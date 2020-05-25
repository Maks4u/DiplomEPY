package com.example.diplomepy.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.diplomepy.R;

public class AboutFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanseState) {
        View root = inflater.inflate(R.layout.fragment_about, container,false);
        return root;
    }
}
