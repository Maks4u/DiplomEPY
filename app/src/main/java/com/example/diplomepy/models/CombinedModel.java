package com.example.diplomepy.models;

import com.example.diplomepy.databse.entities.MainTest;

public class CombinedModel extends MainTest {

   private int count;

    public CombinedModel(String name, int counter, int blocked, int count, int id_main) {
        super(name, counter, blocked, id_main);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

}
