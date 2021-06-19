package com.example.learnenglishapp23032021.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.learnenglishapp23032021.R;
import com.example.learnenglishapp23032021.database.AppDatabase;
import com.example.learnenglishapp23032021.database.entities.WordEntity;
import com.example.learnenglishapp23032021.repository.WordRepository;
import com.example.learnenglishapp23032021.viewmodel.MainViewModel;

import java.util.List;
import java.util.concurrent.ExecutionException;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    MainViewModel mMainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainViewModel = new MainViewModel(getApplication());

        getLifecycle().addObserver(mMainViewModel);

        mMainViewModel.liveDataListWords().observe(this, new Observer<List<WordEntity>>() {
            @Override
            public void onChanged(List<WordEntity> wordEntities) {
                Log.d("BBB",wordEntities.size() + "");
            }
        });


        mMainViewModel.liveDataThrowable().observe(this, new Observer<Throwable>() {
            @Override
            public void onChanged(Throwable throwable) {
                Log.d("BBB",throwable.getMessage());
            }
        });
        mMainViewModel.getListWord();
    }
}