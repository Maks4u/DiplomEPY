package com.example.diplomepy.ui.question.adapterViewFragment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.diplomepy.databse.entities.AnswerTestModel;
import com.example.diplomepy.databse.entities.MainTest;
import com.example.diplomepy.databse.entities.MainTestPart2;
import com.example.diplomepy.databse.entities.QuestionTestModel;
import com.example.diplomepy.repositories.MainRepository;
import com.example.diplomepy.repositories.MainRepositoryPart2;
import com.example.diplomepy.repositories.QuestionRepository;
import com.example.diplomepy.ui.SingleLiveData;
import com.example.diplomepy.ui.question.Singleton;

import java.util.List;

class ArrayListViewModel extends ViewModel {

    private QuestionRepository repository;
    private MainRepository mainRepository;

    private SingleLiveData<Boolean> booleanLiveData;
    private List<QuestionTestModel> questionTestModels;
    private MutableLiveData<QuestionTestModel> getQuestion;
    private MutableLiveData<List<AnswerTestModel>> setAnswers;
    private MainRepositoryPart2 mainRepositoryPart2;
    private SingleLiveData<Boolean> success;

    private final int id;

    ArrayListViewModel(@NonNull Application application, final int id) {

        repository = new QuestionRepository(application);
        mainRepository = new MainRepository(application);

        getQuestion = new MutableLiveData<>();
        booleanLiveData = new SingleLiveData<>();
        setAnswers = new MutableLiveData<>();
        mainRepositoryPart2 = new MainRepositoryPart2(application);
        success = new SingleLiveData<>();

        questionTestModels = Singleton.getInstance().getListQuestion();

        this.id = id;
    }

    LiveData<QuestionTestModel> getQuestion() {
        getQuestion.postValue(questionTestModels.get(id));
        return getQuestion;
    }

    LiveData<List<AnswerTestModel>> getAnswersList() {
        return Transformations.map(repository.getAllAnswer(questionTestModels.get(id).getId_question()), input -> {
            setAnswers.setValue(input);
            return input;
        });
    }

    LiveData<List<AnswerTestModel>> getAnswer() {
        return setAnswers;
    }

    void setCheckCorrect(int positionIndex) {

        AnswerTestModel answersUpgrade = setAnswers.getValue().get(positionIndex);

        if (answersUpgrade.getCorrect() == 0) {
            //incorrect
            booleanLiveData.postValue(false);
        } else {
            //correct
            answersUpgrade.setCorrectAnswer(1);
            repository.update(answersUpgrade);
            booleanLiveData.postValue(true);
        }

    }

    LiveData<Boolean> getCorrect() {
        return booleanLiveData;
    }

    LiveData<Boolean> getSuccess() {
        return success;
    }

    void checkAnswers() {

        Singleton.getInstance().setAnsweredCounter(1);

        if (Singleton.getInstance().getAnsweredCounter() == questionTestModels.size()) {

            MainTest mainTest = Singleton.getInstance().getCounterById(Singleton.getInstance().getTestMainPosition());
            mainTest.setCounter(mainTest.getCounter() + 1);

            mainRepository.update(mainTest);

            if(mainTest.getCounter() == Singleton.getInstance().getSizeListPart2()){

                int currentMainTestPos = Singleton.getInstance().getTestMainPosition();

                int unblockPos = currentMainTestPos + 1;

                if(unblockPos < Singleton.getInstance().getSizeMainTestList()){
                    MainTest mainTest1 = Singleton.getInstance().getCounterById(unblockPos);
                    mainRepository.update(new MainTest(mainTest1.getName(), mainTest1.getCounter(), 1, mainTest1.getId_main()));

                }
            }

            MainTestPart2 mainTestPart2 = Singleton.getInstance().getTestByIndex(Singleton.getInstance().getCurrentTestId());
            mainTestPart2.setBlocked(1);
            mainRepositoryPart2.update(mainTestPart2);

            success.postValue(true);

            Singleton.getInstance().setAnsweredCounter(0);
        }
    }

}