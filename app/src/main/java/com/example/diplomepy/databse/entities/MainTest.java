package com.example.diplomepy.databse.entities;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "main")
public class MainTest {

    @PrimaryKey(autoGenerate = true)
    private int id_main;
    private String name;
    private int counter;
    private int blocked;
    public MainTest(String name, int counter, int blocked, int id_main) {
        this.name = name;
        this.counter = counter;
        this.blocked = blocked;
        this.id_main = id_main;
    }

    public int getId_main() {
        return id_main;
    }
    public String getName() {
        return name;
    }
    public int getCounter() {
        return counter;
    }
    public int getBlocked(){return blocked;}

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
