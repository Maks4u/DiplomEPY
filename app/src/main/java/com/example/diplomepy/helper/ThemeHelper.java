package com.example.diplomepy.helper;

import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.diplomepy.R;

public class ThemeHelper {

    public static void setTheme(final String theme, final Context context) {

        final String dark = context.getString(R.string.theme_dark);
        final String light = context.getString(R.string.theme_light);
        final String system = context.getString(R.string.theme_system);

        if (theme.equals(dark)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else if (theme.equals(light)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else if (theme.equals(system)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }
}
