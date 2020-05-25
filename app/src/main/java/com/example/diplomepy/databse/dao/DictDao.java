package com.example.diplomepy.databse.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.diplomepy.databse.entities.DictModel;

import java.util.List;

@Dao
public interface DictDao {

    @Update
    void update(DictModel note);

    @Insert
    void insert(DictModel note);

    @Delete
    void delete(DictModel note);

    @Query("SELECT * FROM dict ORDER BY id_dict ")
    LiveData<List<DictModel>> getAllDict();
}
