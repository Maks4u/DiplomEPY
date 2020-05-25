package com.example.diplomepy.databse.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import com.example.diplomepy.databse.entities.ImageTestModel;

import java.util.List;

@Dao
public interface PictureDao {

    @Update
    void update(ImageTestModel note);

    @Query("SELECT * FROM picture WHERE id_lesson = :id")
    LiveData<List<ImageTestModel>> getAllPicture(int id);
}
