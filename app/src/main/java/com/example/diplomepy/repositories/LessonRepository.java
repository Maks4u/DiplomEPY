package com.example.diplomepy.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.diplomepy.databse.MainDatabase;
import com.example.diplomepy.databse.dao.PictureDao;
import com.example.diplomepy.databse.dao.TextDao;
import com.example.diplomepy.databse.entities.ImageTestModel;
import com.example.diplomepy.databse.entities.TextTestModel;

import java.util.List;

public class LessonRepository {
    private final TextDao textDao;
    private final PictureDao pictureDao;


    public LessonRepository(Application application) {
        MainDatabase database = MainDatabase.getInstance(application);
        textDao = database.textDao();
        pictureDao = database.pictureDao();
    }

    public LiveData<List<TextTestModel>> getAllText(int id) {
        return textDao.getAllText(id);
    }

    public LiveData<List<ImageTestModel>> getAllPicture(int id) {
        return pictureDao.getAllPicture(id);
    }


    public void update() {

    }
}
