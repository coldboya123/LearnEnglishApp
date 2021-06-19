package com.example.learnenglishapp23032021.viewmodel;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.learnenglishapp23032021.database.AppDatabase;
import com.example.learnenglishapp23032021.database.WordDao;
import com.example.learnenglishapp23032021.database.entities.WordEntity;
import com.example.learnenglishapp23032021.repository.WordRepository;

import java.util.List;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {
    private WordRepository wordRepository;
    private WordDao wordDao;

    private MutableLiveData<List<WordEntity>> mutableListWord;
    private MutableLiveData<Throwable> mutableThrowable;

    public MainViewModel(@NonNull Application application) {
        super(application);
        wordDao = AppDatabase.getInstance(application).wordDao();
        wordRepository = new WordRepository(wordDao);
        mutableListWord = new MutableLiveData<>();
        mutableThrowable = new MutableLiveData<>();
    }

    public LiveData<List<WordEntity>> liveDataListWords(){
        return mutableListWord;
    }

    public LiveData<Throwable> liveDataThrowable(){
        return mutableThrowable;
    }

    public void getListWord(){
        wordRepository
                .getWords()
                .map(new Function<List<WordEntity>, List<WordEntity>>() {
                    @Override
                    public List<WordEntity> apply(List<WordEntity> wordEntities) throws Throwable {
                        for (int i = 0; i <wordEntities.size() ; i++) {
                            wordEntities.get(i).setEn(wordEntities.get(i).getEn().toUpperCase());
                            wordEntities.get(i).setVn(wordEntities.get(i).getVn().toUpperCase());
                        }
                        return wordEntities;
                    }
                })
                .toObservable()
                .subscribe(new Observer<List<WordEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<WordEntity> wordEntities) {
                        mutableListWord.setValue(wordEntities);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mutableThrowable.setValue(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void clearData(){
        mutableListWord = null;
        mutableThrowable = null;
    }
}
