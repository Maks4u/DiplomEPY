package com.example.diplomepy.ui.sites;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.diplomepy.R;

public class SitesFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sites, container, false);
        root.findViewById(R.id.frame1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ru.wikipedia.org/wiki/Python"));
                startActivity(I);
            }
        });
        root.findViewById(R.id.frame2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Intent.ACTION_VIEW, Uri.parse("https://python-scripts.com/"));
                startActivity(I);
            }
        });
        root.findViewById(R.id.frame3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.python.org/doc/"));
                startActivity(I);
            }
        });
        root.findViewById(R.id.frame4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pythonworld.ru/osnovy/dokumentirovanie-koda-v-python-pep-257.html"));
                startActivity(I);
            }
        });

        root.findViewById(R.id.frame5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.python.org/"));
                startActivity(I);
            }
        });
        root.findViewById(R.id.frame6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Intent.ACTION_VIEW, Uri.parse("https://stackoverflow.com/"));
                startActivity(I);
            }
        });
        root.findViewById(R.id.frame7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Intent.ACTION_VIEW, Uri.parse("https://knute.edu.ua/"));
                startActivity(I);
            }
        });
        return root;
    }
}
