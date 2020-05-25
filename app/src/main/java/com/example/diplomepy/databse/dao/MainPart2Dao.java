package com.example.diplomepy.databse.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import com.example.diplomepy.databse.entities.MainTestPart2;

import java.util.List;

@Dao
public interface MainPart2Dao {

    @Update
    void update(MainTestPart2 note);

    @Query("SELECT * FROM lessons WHERE id_main = :id")
    LiveData<List<MainTestPart2>> getAllTestsPart2(int id);

    @Query("SELECT COUNT(*) FROM lessons WHERE id_main = :id")
    int countSize(int id);

}
