package com.example.diplomepy.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.diplomepy.databse.MainDatabase;
import com.example.diplomepy.databse.dao.MainPart2Dao;
import com.example.diplomepy.databse.entities.MainTest;
import com.example.diplomepy.databse.entities.MainTestPart2;
import com.example.diplomepy.models.CombinedModel;

import java.util.ArrayList;
import java.util.List;

public class MainRepositoryPart2 {
    private final MainPart2Dao mainPart2Dao;

    private final MutableLiveData<List<CombinedModel>> listMutableLiveData;

    public MainRepositoryPart2(Application application) {
        MainDatabase database = MainDatabase.getInstance(application);
        mainPart2Dao = database.mainPart2Dao();

        listMutableLiveData = new MutableLiveData<>();

    }

    public void update(MainTestPart2 note) {
        MainDatabase.executorService.submit(() -> mainPart2Dao.update(note));
    }

    public LiveData<List<MainTestPart2>> getAllTestsPart2(int id) {
        return mainPart2Dao.getAllTestsPart2(id);
    }

    public LiveData<List<CombinedModel>> getCountSize(List<MainTest> data) {

        List<CombinedModel> integerList = new ArrayList<>();

        MainDatabase.executorService.submit(() -> {

            for (MainTest some : data) {
                integerList.add(new CombinedModel(some.getName(), some.getCounter(), some.getBlocked(), mainPart2Dao.countSize(some.getId_main()), some.getId_main()));
            }
            listMutableLiveData.postValue(integerList);
        });

        return listMutableLiveData;
    }

}
