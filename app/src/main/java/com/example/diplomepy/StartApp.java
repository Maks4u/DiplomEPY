package com.example.diplomepy;

import android.app.Application;
import androidx.preference.PreferenceManager;
import com.example.diplomepy.helper.ThemeHelper;

public class StartApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        final String theme = PreferenceManager.getDefaultSharedPreferences(this)
                .getString(getString(R.string.preferences_theme_key), getString(R.string.preferences_theme_default));

        ThemeHelper.setTheme(theme, this);

    }
}
