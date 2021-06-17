package com.example.learnenglishapp23032021.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word")
public class WordEntity {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String en;
    private String vn;

    @ColumnInfo(name = "ismemorized" , defaultValue = "0")
    private boolean isMemorized;

    public WordEntity(String en , String vn){
        this.en = en;
        this.vn = vn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public boolean isMemorized() {
        return isMemorized;
    }

    public void setMemorized(boolean memorized) {
        isMemorized = memorized;
    }

    @Override
    public String toString() {
        return "WordEntity{" +
                "id=" + id +
                ", en='" + en + '\'' +
                ", vn='" + vn + '\'' +
                ", isMemorized=" + isMemorized +
                '}';
    }
}
