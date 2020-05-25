package com.example.diplomepy.databse.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "question", foreignKeys =  @ForeignKey(
        entity = MainTestPart2.class,
        parentColumns = "id_lesson",
        childColumns = "id_lesson"))
public class QuestionTestModel {

    @PrimaryKey(autoGenerate = true)
    private int id_question;
    private String question;
    private int id_lesson;

    public QuestionTestModel(int id_question, String question, int id_lesson) {
        this.id_question = id_question;
        this.question = question;
        this.id_lesson = id_lesson;
    }

    public int getId_question() {
        return id_question;
    }
    public void setId_question(int id_question) {
        this.id_question = id_question;
    }
    public String getQuestion() {
        return question;
    }
    public int getId_lesson() {
        return id_lesson;
    }
}
