package com.example.learnenglishapp23032021.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.learnenglishapp23032021.R;
import com.example.learnenglishapp23032021.database.AppDatabase;
import com.example.learnenglishapp23032021.database.entities.WordEntity;
import com.example.learnenglishapp23032021.repository.WordRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}