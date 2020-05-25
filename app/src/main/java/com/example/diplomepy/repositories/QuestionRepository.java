package com.example.diplomepy.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.diplomepy.databse.MainDatabase;
import com.example.diplomepy.databse.dao.AnswerDao;
import com.example.diplomepy.databse.dao.QuestionDao;
import com.example.diplomepy.databse.entities.AnswerTestModel;
import com.example.diplomepy.databse.entities.QuestionTestModel;


import java.util.List;

public class QuestionRepository {
    private final QuestionDao questionDao;
    private final AnswerDao answerDao;

    public QuestionRepository(Application application) {
        MainDatabase database = MainDatabase.getInstance(application);
        questionDao = database.questionDao();
        answerDao = database.answerDao();
    }

    public LiveData<List<QuestionTestModel>> getAllQuestion(int id) {
        return questionDao.getAllQuestion(id);
    }

//    public LiveData<List<AnswersUpgrade>> getAllAnswer (int id){
//        return Transformations.map(answerDao.getAllAnswer(id), Mapper::AnswerTestModelToAnswersUpgrade);
//    }

//    public void update(AnswersUpgrade answersUpgrade) {
//        MainDatabase.executorService.submit(() ->  answerDao.update(Mapper.answerUpgradeToAnswerTestModel(answersUpgrade)));
//    }

    public void update(AnswerTestModel note) {
        MainDatabase.executorService.submit(() -> answerDao.update(note));
    }

    public LiveData<List<AnswerTestModel>> getAllAnswer(int id) {
        return answerDao.getAllAnswer(id);
    }
}
