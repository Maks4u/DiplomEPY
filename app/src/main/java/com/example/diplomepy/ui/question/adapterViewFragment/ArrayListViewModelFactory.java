package com.example.diplomepy.ui.question.adapterViewFragment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ArrayListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final Application application;
    public final int id;

    public ArrayListViewModelFactory(final Application application,final int id) {
        super();

        this.application = application;
        this.id = id;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ArrayListViewModel(application, id);
    }
}