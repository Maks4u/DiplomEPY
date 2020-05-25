package com.example.diplomepy.models;

import com.example.diplomepy.databse.entities.AnswerTestModel;

public class AnswersUpgrade extends AnswerTestModel {

    private int correctAnswer;

    public AnswersUpgrade(int id_answer, String answer, int id_question, int correct, int correctAnswer) {
        super(id_answer, answer, id_question, correct, correctAnswer);
        this.correctAnswer = correctAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
