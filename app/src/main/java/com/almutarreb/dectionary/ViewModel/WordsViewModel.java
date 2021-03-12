package com.almutarreb.dectionary.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.almutarreb.dectionary.Entities.Words;
import com.almutarreb.dectionary.Repostery.WordsRepository;

import java.util.List;

public class WordsViewModel extends AndroidViewModel {
    private WordsRepository mRepository;
    private LiveData<List<Words>>mAllWords;
    public WordsViewModel(@NonNull Application application) {
        super(application);
        mRepository=new WordsRepository(application);
        mAllWords=mRepository.getAllWords();
    }
    public void insert(Words word)
    {
        mRepository.insert(word);
    }
    public void update(Words words)
    {
mRepository.update(words);
    }
    public void delete (Words words)
    {
        mRepository.delete(words);
    }
    public  void delete_all_words()
    {
        mRepository.DeleteAllWords();
    }
    public LiveData<List<Words>> getdata()
    {
       return mAllWords;
    }

}
