package com.example.diplomepy.ui.glossary;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.diplomepy.databse.entities.DictModel;
import com.example.diplomepy.repositories.DictRepository;

import java.util.List;

public class DictViewModel extends AndroidViewModel {
    private DictRepository repository;
    private MutableLiveData<List<DictModel>> allDict;

    public DictViewModel(@NonNull Application application) {
        super(application);
        repository = new DictRepository(application);
        allDict = new MutableLiveData<>();
    }

    public void update(DictModel note) {
        repository.update(note);
    }

    public void insert(DictModel note) {
        repository.insert(note);
    }

    public void delete(DictModel note) {
        repository.delete(note);
    }



    LiveData<List<DictModel>> getAllDict() {
        return Transformations.map(repository.getAllDict(), data -> {
            allDict.postValue(data);
            return data;
        });
    }
}
