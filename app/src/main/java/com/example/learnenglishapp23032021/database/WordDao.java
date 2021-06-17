package com.example.learnenglishapp23032021.database;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.learnenglishapp23032021.database.entities.WordEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface WordDao {
    @Query("SELECT * FROM  word")
    Flowable<List<WordEntity>> getWords();
}
