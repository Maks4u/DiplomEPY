package com.example.diplomepy.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.diplomepy.databse.MainDatabase;
import com.example.diplomepy.databse.dao.DictDao;
import com.example.diplomepy.databse.entities.DictModel;

import java.util.List;

public class DictRepository {

    private final DictDao dictDao;

    public DictRepository(Application application) {
        MainDatabase database = MainDatabase.getInstance(application);
        dictDao = database.dictDao();
    }

    public void update(DictModel note) {
        MainDatabase.executorService.submit(() -> dictDao.update(note));
    }

    public void insert(DictModel note) {
        MainDatabase.executorService.submit(() -> dictDao.insert(note));
    }

    public void delete(DictModel note) {
        MainDatabase.executorService.submit(() -> dictDao.delete(note));
    }

    public LiveData<List<DictModel>> getAllDict() {
        return dictDao.getAllDict();
    }

}
