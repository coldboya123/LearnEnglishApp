package com.example.learnenglishapp23032021.repository;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.learnenglishapp23032021.database.WordDao;
import com.example.learnenglishapp23032021.database.entities.WordEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WordRepository {
    WordDao wordDao;

    public WordRepository(WordDao wordDao) {
        this.wordDao = wordDao;
    }

    public Flowable<List<WordEntity>> getWords() {
        return wordDao.getWords()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
