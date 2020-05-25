package com.example.diplomepy.databse.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "lessons", foreignKeys =  @ForeignKey(
        entity = MainTest.class,
        parentColumns = "id_main",
        childColumns = "id_main"))
public class MainTestPart2 {
    @PrimaryKey(autoGenerate = true)
    private int id_lesson;
    private String name_lesson;
    private int id_main;
    private int blocked;

    public MainTestPart2(String name_lesson, int id_main, int blocked) {
        this.name_lesson = name_lesson;
        this.id_main = id_main;
        this.blocked = blocked;
    }
    public void setId_lesson(int id_lesson) {
        this.id_lesson = id_lesson;
    }
    public int getId_lesson() {
        return id_lesson;
    }
    public String getName_lesson() {
        return name_lesson;
    }
    public int getId_main() {
        return id_main;
    }
    public int getBlocked(){return blocked;}

    public void setBlocked(int blocked) {
        this.blocked = blocked;
    }
}
