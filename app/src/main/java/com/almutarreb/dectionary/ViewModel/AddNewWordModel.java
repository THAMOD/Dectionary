package com.almutarreb.dectionary.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.almutarreb.dectionary.Entities.Words;
import com.almutarreb.dectionary.Repostery.WordsRepository;

import java.util.List;

public class AddNewWordModel extends AndroidViewModel {

    private WordsRepository mRepository;
    public AddNewWordModel(@NonNull Application application) {
        super(application);
        mRepository=new WordsRepository(application);
    }
    public void insert(Words word)
    {
        mRepository.insert(word);
    }
    public void update(Words words)
    {
        mRepository.update(words);
    }

}
