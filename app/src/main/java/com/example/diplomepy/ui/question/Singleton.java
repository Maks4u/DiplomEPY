package com.example.diplomepy.ui.question;

import com.example.diplomepy.databse.entities.MainTest;
import com.example.diplomepy.databse.entities.MainTestPart2;
import com.example.diplomepy.databse.entities.QuestionTestModel;

import java.util.List;

public class Singleton {

    private static volatile Singleton instance;

    private int answeredCounter = 0;
    private int currentTestId = 0;
    private List<QuestionTestModel> lists;
    private List<MainTestPart2> testList;
    private List<MainTest> mainTestList;
    private int testMainId;

    public static Singleton getInstance() {
        Singleton localInstance = instance;
        if (localInstance == null) {
            synchronized (Singleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Singleton();
                }
            }
        }
        return localInstance;
    }

    void setListQuestions(List<QuestionTestModel> questions){
        lists = questions;
    }

    public List<QuestionTestModel> getListQuestion(){
        return lists;
    }

    public void setListPart2(List<MainTestPart2> mainTestPart2s) {
        testList = mainTestPart2s;
    }

    public int getSizeListPart2(){
        return testList.size();
    }

    public List<MainTestPart2> getTestList() {
        return testList;
    }

    public MainTestPart2 getTestByIndex(int index){
        return testList.get(index);
    }

    public void setCurrentTestId(int id){
        if(id + 1 < testList.size()) {
            currentTestId = id + 1;
        }
    }

    public int getCurrentTestId(){
        return currentTestId;
    }

    public void setAnsweredCounter(int id){
        answeredCounter++;
        if(id == 0){
            answeredCounter = 0;
        }
    }

    public void setMainTestList(List<MainTest> mainTestList) {
        this.mainTestList = mainTestList;

    }

    public int getSizeMainTestList() {
        return mainTestList.size();
    }

    public MainTest getCounterById(int id) {
        return mainTestList.get(id);
    }

    public int getAnsweredCounter(){
        return answeredCounter;
    }

    //adapter position
    public void setTestMainPosition(int testMainId){
        this.testMainId = testMainId;
    }

    public int getTestMainPosition(){
        return testMainId;
    }

}
