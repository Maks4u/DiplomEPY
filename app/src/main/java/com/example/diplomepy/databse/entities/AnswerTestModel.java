package com.example.diplomepy.databse.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "answers", foreignKeys = @ForeignKey(
        entity = QuestionTestModel.class,
        parentColumns = "id_question",
        childColumns = "id_question"))
public class AnswerTestModel {

    @PrimaryKey(autoGenerate = true)
    private int id_answer;
    private String answer;
    private int id_question;
    private int correct;
    private int correctAnswer;

    public AnswerTestModel(int id_answer, String answer, int id_question, int correct, int correctAnswer) {
        this.id_answer = id_answer;
        this.answer = answer;
        this.id_question = id_question;
        this.correct = correct;
        this.correctAnswer = correctAnswer;
    }

    public int getId_answer() {
        return id_answer;
    }

    public void setId_answer(int id_answer) {
        this.id_answer = id_answer;
    }

    public String getAnswer() {
        return answer;
    }

    public int getId_question() {
        return id_question;
    }

    public int getCorrect() {
        return correct;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

}
