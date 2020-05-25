package com.example.diplomepy.ui.lesson;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class LessonsViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final Application application;
    public final int id;

    public LessonsViewModelFactory(final Application application, int id) {
        super();

        this.application = application;
        this.id = id;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LessonsViewModel(application, id);
    }
}
