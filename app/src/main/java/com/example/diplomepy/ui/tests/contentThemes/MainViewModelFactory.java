package com.example.diplomepy.ui.tests.contentThemes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final Application application;
    private final int id;

    public MainViewModelFactory(final int id, final Application application) {
        this.id = id;
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModelPart2(application, id);
    }
}
