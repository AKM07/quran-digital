package com.example.akm.quran_digital.entity;

import java.io.Serializable;

/**
 * Created by akm on 2/5/18.
 */

public class Surah implements Serializable {

    private int id;
    private String name;

    public Surah(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
