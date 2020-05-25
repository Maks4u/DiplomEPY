package com.example.diplomepy.ui.question;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.diplomepy.databse.entities.QuestionTestModel;
import com.example.diplomepy.repositories.QuestionRepository;

import java.util.List;

public class QuestionViewModel extends AndroidViewModel {

    private QuestionRepository repository;
    private MutableLiveData<List<QuestionTestModel>> allQuestions;

    public QuestionViewModel(@NonNull Application application) {
        super(application);
            repository = new QuestionRepository(application);
            allQuestions = new MutableLiveData<>();
    }

    LiveData<List<QuestionTestModel>> getAllQuestions(int id) {
        return Transformations.map(repository.getAllQuestion(id), input -> {
            allQuestions.postValue(input);
            return input;
        });
    }

}