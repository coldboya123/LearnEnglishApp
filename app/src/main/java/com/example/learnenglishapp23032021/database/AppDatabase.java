package com.example.learnenglishapp23032021.database;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import androidx.annotation.IntRange;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.learnenglishapp23032021.database.entities.WordEntity;

import java.util.concurrent.TimeUnit;

@Database(entities = WordEntity.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WordDao wordDao();

    public static AppDatabase instance = null;

    @SuppressLint("UnsafeOptInUsageError")
    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance =  Room.databaseBuilder(
                    context,
                    AppDatabase.class,
                    "Appdatabase.sql")
                    .setAutoCloseTimeout(5, TimeUnit.SECONDS)
                    .build();
        }
        return instance;
    }
}
