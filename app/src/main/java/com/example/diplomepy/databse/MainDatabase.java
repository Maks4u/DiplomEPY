package com.example.diplomepy.databse;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.diplomepy.databse.dao.AnswerDao;
import com.example.diplomepy.databse.dao.DictDao;
import com.example.diplomepy.databse.dao.MainDao;
import com.example.diplomepy.databse.dao.MainPart2Dao;
import com.example.diplomepy.databse.dao.PictureDao;
import com.example.diplomepy.databse.dao.QuestionDao;
import com.example.diplomepy.databse.dao.TextDao;
import com.example.diplomepy.databse.entities.AnswerTestModel;
import com.example.diplomepy.databse.entities.DictModel;
import com.example.diplomepy.databse.entities.ImageTestModel;
import com.example.diplomepy.databse.entities.MainTest;
import com.example.diplomepy.databse.entities.MainTestPart2;
import com.example.diplomepy.databse.entities.QuestionTestModel;
import com.example.diplomepy.databse.entities.TextTestModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {MainTest.class, MainTestPart2.class, TextTestModel.class, ImageTestModel.class, DictModel.class, QuestionTestModel.class, AnswerTestModel.class}, version = 1)
public abstract class MainDatabase extends RoomDatabase {

    private static MainDatabase instance;
    public static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static synchronized MainDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MainDatabase.class, "main")
                    .createFromAsset("epy_db.db")
                    .build();
        }
        return instance;
    }

    public abstract MainPart2Dao mainPart2Dao();

    public abstract TextDao textDao();

    public abstract PictureDao pictureDao();

    public abstract DictDao dictDao();

    public abstract MainDao mainDao();

    public abstract QuestionDao questionDao();

    public abstract AnswerDao answerDao();

}
