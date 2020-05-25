package com.example.diplomepy.databse.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "picture", foreignKeys =  @ForeignKey(
        entity = MainTestPart2.class,
        parentColumns = "id_lesson",
        childColumns = "id_lesson"))
public class ImageTestModel implements BaseModel {

    @PrimaryKey(autoGenerate = true)
    private int id_picture;
    private String picture;
    private int id_lesson;

    public ImageTestModel(int id_picture, String picture, int id_lesson) {
        this.id_picture = id_picture;
        this.picture = picture;
        this.id_lesson = id_lesson;
    }

    public int getId_picture() {
        return id_picture;
    }
    public void setId_picture(int id_picture) {
        this.id_picture = id_picture;
    }
    public String getPicture() {
        return picture;
    }
    public int getId_lesson() {
        return id_lesson;
    }


}
