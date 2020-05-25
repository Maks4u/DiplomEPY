package com.example.diplomepy.databse.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import com.example.diplomepy.databse.entities.QuestionTestModel;

import java.util.List;

@Dao
public interface QuestionDao {

    @Update
    void update(QuestionTestModel note);

    @Query("SELECT * FROM question WHERE id_lesson = :id")
    LiveData<List<QuestionTestModel>> getAllQuestion(int id);
}
