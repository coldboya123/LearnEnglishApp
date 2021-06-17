package com.example.learnenglishapp23032021.repository;

import androidx.constraintlayout.helper.widget.Flow;

import com.example.learnenglishapp23032021.database.WordDao;
import com.example.learnenglishapp23032021.database.entities.WordEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class WordRepository {
    WordDao wordDao;

    public WordRepository(WordDao wordDao){
        this.wordDao = wordDao;
    }

    public Flowable<List<WordEntity>> getWords(){
        return wordDao.getWords();
    }
}
