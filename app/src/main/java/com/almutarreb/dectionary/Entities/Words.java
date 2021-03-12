package com.almutarreb.dectionary.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="wordTable" )
public class Words {
    @PrimaryKey(autoGenerate = true)
    private  int id ;
    private String wordname;
    private  String wordMean;
    @ColumnInfo(name = "Type")
    private  String wordType;

    public Words(String wordname, String wordMean, String wordType) {
        this.wordname = wordname;
        this.wordMean = wordMean;
        this.wordType = wordType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getWordname() {
        return wordname;
    }

    public String getWordMean() {
        return wordMean;
    }

    public String getWordType() {
        return wordType;
    }
}
