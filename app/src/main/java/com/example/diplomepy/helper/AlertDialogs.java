package com.example.diplomepy.helper;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.preference.PreferenceManager;

import com.example.diplomepy.R;

public class AlertDialogs extends DialogFragment {

    private final TextHelper.RecreateApp recreateApp;

    public AlertDialogs(TextHelper.RecreateApp recreateApp) {
        this.recreateApp = recreateApp;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Ви впевнені, що бажаєте це зробити?")
                .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences.Editor prefs = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
                        prefs.putString(getString(R.string.preferences_text_key), getString(R.string.preferences_text_default));
                        prefs.apply();

                        SharedPreferences.Editor prefsTheme = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
                        prefsTheme.putString(getString(R.string.preferences_theme_key), getString(R.string.preferences_theme_default));
                        prefsTheme.apply();

                        dismiss();
                    }
                })
                .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dismiss();
                    }
                });
        return builder.create();
    }


}
