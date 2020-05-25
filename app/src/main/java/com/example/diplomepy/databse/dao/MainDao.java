package com.example.diplomepy.databse.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import com.example.diplomepy.databse.entities.MainTest;

import java.util.List;

@Dao
public interface MainDao {

    @Update
    void update(MainTest note);

    @Query("SELECT * FROM main ORDER BY id_main ")
    LiveData<List<MainTest>> getAllTests();
}
