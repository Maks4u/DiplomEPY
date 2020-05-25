package com.example.diplomepy.databse.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "text", foreignKeys =  @ForeignKey(
        entity = MainTestPart2.class,
        parentColumns = "id_lesson",
        childColumns = "id_lesson"))
public class TextTestModel implements BaseModel {

    @PrimaryKey(autoGenerate = true)
    private int id_text;
    private String text;
    private int id_lesson;

    public TextTestModel(int id_text, String text, int id_lesson) {
        this.id_text = id_text;
        this.text = text;
        this.id_lesson = id_lesson;
    }

    public int getId_text() {
        return id_text;
    }
    public void setId_text(int id_text) {
        this.id_text = id_text;
    }
    public String getText() {
        return text;
    }
    public int getId_lesson() {
        return id_lesson;
    }
}
