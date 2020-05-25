package com.example.diplomepy.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.diplomepy.databse.MainDatabase;
import com.example.diplomepy.databse.dao.MainDao;
import com.example.diplomepy.databse.entities.MainTest;

import java.util.List;

public class MainRepository {

    private final MainDao mainDao;
    public MainRepository(Application application) {
        MainDatabase database = MainDatabase.getInstance(application);
        mainDao = database.mainDao();
    }

    public void update(MainTest note) {
        MainDatabase.executorService.submit(() -> mainDao.update(note));
    }

    public LiveData<List<MainTest>> getAllTests() {
        return mainDao.getAllTests();
    }
}
