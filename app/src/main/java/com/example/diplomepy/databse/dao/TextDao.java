package com.example.diplomepy.databse.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import com.example.diplomepy.databse.entities.TextTestModel;

import java.util.List;

@Dao
public interface TextDao {

    @Update
    void update(TextTestModel note);

    @Query("SELECT * FROM text WHERE id_lesson = :id")
    LiveData<List<TextTestModel>> getAllText(int id);
}
