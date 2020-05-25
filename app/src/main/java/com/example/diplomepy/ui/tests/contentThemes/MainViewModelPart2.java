package com.example.diplomepy.ui.tests.contentThemes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.diplomepy.databse.entities.MainTestPart2;
import com.example.diplomepy.repositories.MainRepositoryPart2;

import java.util.List;

public class MainViewModelPart2 extends ViewModel {

    private MainRepositoryPart2 repository2;
    private MutableLiveData<List<MainTestPart2>> allTestsPart2;
    private final int id;

    public MainViewModelPart2(@NonNull Application application, final int id) {
        repository2 = new MainRepositoryPart2(application);
        allTestsPart2 = new MutableLiveData<>();
        this.id = id;
    }

    public void update(MainTestPart2 note) {
        repository2.update(note);
    }

    LiveData<List<MainTestPart2>> getAllTestsPart2() {
        return Transformations.map(repository2.getAllTestsPart2(id), input -> {
            allTestsPart2.postValue(input);
            return input;
        });
    }

}
