package com.example.akm.quran_digital.entity;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by akm on 2/5/18.
 */

public class Quran extends RealmObject implements Serializable {

    private int DatabaseID;
    private int SuraID;
    private int VerseID;
    private String AyahText;


    public int getDatabaseID() {
        return DatabaseID;
    }

    public void setDatabaseID(int databaseID) {
        DatabaseID = databaseID;
    }

    public int getSuraID() {
        return SuraID;
    }

    public void setSuraID(int suraID) {
        SuraID = suraID;
    }

    public int getVerseID() {
        return VerseID;
    }

    public void setVerseID(int verseID) {
        VerseID = verseID;
    }

    public String getAyahText() {
        return AyahText;
    }

    public void setAyahText(String ayahText) {
        AyahText = ayahText;
    }
}
