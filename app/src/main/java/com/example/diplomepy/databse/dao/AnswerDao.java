package com.example.diplomepy.databse.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import com.example.diplomepy.databse.entities.AnswerTestModel;

import java.util.List;

@Dao
public interface AnswerDao {

    @Update
    void update(AnswerTestModel note);

    @Query("SELECT * FROM answers WHERE id_question = :id")
    LiveData<List<AnswerTestModel>> getAllAnswer(int id);
}
