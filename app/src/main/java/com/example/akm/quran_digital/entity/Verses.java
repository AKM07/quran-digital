package com.example.akm.quran_digital.entity;

import java.io.Serializable;

/**
 * Created by akm on 2/5/18.
 */

public class Verses implements Serializable {

    private int verseId;
    private String verseText;
    private String verseTranslation;

    public int getVerseId() {
        return verseId;
    }

    public void setVerseId(int verseId) {
        this.verseId = verseId;
    }

    public String getVerseText() {
        return verseText;
    }

    public void setVerseText(String verseText) {
        this.verseText = verseText;
    }

    public String getVerseTranslation() {
        return verseTranslation;
    }

    public void setVerseTranslation(String verseTranslation) {
        this.verseTranslation = verseTranslation;
    }
}
