package com.example.diplomepy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.diplomepy.helper.AlertDialogs;
import com.example.diplomepy.helper.TextHelper;
import com.example.diplomepy.helper.ThemeHelper;

public class Settings extends PreferenceFragmentCompat implements
        SharedPreferences.OnSharedPreferenceChangeListener, TextHelper.RecreateApp {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.settings);

        final AlertDialogs alertDialogs = new AlertDialogs(this);

        Preference button = findPreference(getString(R.string.set_drop_prog));
        button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                alertDialogs.show(getChildFragmentManager(), "some_text");

                return true;
            }
        });

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals(getString(R.string.preferences_theme_key))){
            final Context context = getContext();

            if (context != null) {
                final String theme = sharedPreferences.getString(key, getString(R.string.preferences_theme_default));
                ThemeHelper.setTheme(theme, getContext());
            }
        }

        if(key.equals(getString(R.string.preferences_text_key))){
            final Context context = getContext();

            if (context != null && getActivity() != null) {
                final String text = sharedPreferences.getString(key, getString(R.string.preferences_text_default));
                TextHelper.setText(text, getContext(), this);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void recreate(){
        if(getActivity()!=null) {
            getActivity().recreate();
        }
    }

}
