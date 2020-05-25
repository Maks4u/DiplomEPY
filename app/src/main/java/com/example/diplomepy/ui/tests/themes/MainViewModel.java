package com.example.diplomepy.ui.tests.themes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.diplomepy.databse.entities.MainTest;
import com.example.diplomepy.repositories.MainRepository;
import com.example.diplomepy.repositories.MainRepositoryPart2;
import com.example.diplomepy.models.CombinedModel;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private MainRepository repository;
    private MainRepositoryPart2 mainRepositoryPart2;
    private MutableLiveData<List<MainTest>> allTests;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new MainRepository(application);
        mainRepositoryPart2 = new MainRepositoryPart2(application);

        allTests = new MutableLiveData<>();
    }

    public void update(MainTest note) {
        repository.update(note);
    }

    LiveData<List<MainTest>> getAllTests() {
       return Transformations.map(repository.getAllTests(), data -> data);
    }

    LiveData<List<CombinedModel>> mapper(List<MainTest> data){
        return Transformations.map(mainRepositoryPart2.getCountSize(data), input -> input);
    }

}
