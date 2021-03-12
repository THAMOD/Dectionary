package com.almutarreb.dectionary.Repostery;
import android.app.Application;
import android.app.AsyncNotedAppOp;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.almutarreb.dectionary.Dao.WordsDao;
import com.almutarreb.dectionary.Entities.Words;
import com.almutarreb.dectionary.RoomDB.WordRoomDB;

import java.util.List;

import javax.xml.transform.Result;

public class WordsRepository {
    private WordsDao mWordsDao;
    private LiveData<List<Words>>getAllWords;
    public WordsRepository(Application app)
    {
        WordRoomDB db=WordRoomDB.getInstance(app);
        mWordsDao =db.wordsDao();
        getAllWords=mWordsDao.getAllWords();
    }
    //insert
    public void insert(Words word)
    {
new InsertAsyncTask(mWordsDao).execute(word);
    }
    // update
    public void update(Words word)
    {
new UpdateAsyncTask(mWordsDao).execute(word);
    }
    //delete
    public  void delete(Words word)
    {
new DeleteAsyncTask(mWordsDao).execute(word);
    }
    // delete all words
    //get all wordds
    public LiveData<List<Words>> getAllWords()
    {
        return  getAllWords;
    }
    public  void DeleteAllWords()
    {
new DeleteAsyncTask(mWordsDao).execute();
    }

    //insert thread
private  static class InsertAsyncTask extends AsyncTask<Words,Void,Void>
{
    private  WordsDao mWordsDao;
    public  InsertAsyncTask(WordsDao mWordsDao)
    {
        this.mWordsDao=mWordsDao;
    }
    @Override
    protected Void doInBackground(Words... words)
    {
        mWordsDao.insert(words[0]);
    return  null;
    }
}
 //update thread
 private  static class UpdateAsyncTask extends AsyncTask<Words,Void,Void>
 {
     private  WordsDao mWordsDao;
     public  UpdateAsyncTask(WordsDao mWordsDao)
     {
         this.mWordsDao=mWordsDao;
     }
     @Override
     protected Void doInBackground(Words... words)
     {
         mWordsDao.update(words[0]);
         return  null;
     }
 }
 //delete thread
 private  static class DeleteAsyncTask extends AsyncTask<Words,Void,Void>
 {
     private  WordsDao mWordsDao;
     public DeleteAsyncTask(WordsDao mWordsDao)
     {
         this.mWordsDao=mWordsDao;
     }
     @Override
     protected Void doInBackground(Words... words)
     {
         mWordsDao.delete(words[0]);
         return  null;
     }
 }
 //delete all word thread
    private static class DeleteAllWords extends AsyncTask<Void,Void,Void>
 {
     private  WordsDao mWordsDao;
    public DeleteAllWords (WordsDao mWordsDao)
    {
        this.mWordsDao=mWordsDao;

    }
     @Override
     protected Void doInBackground(Void... voids) {
        mWordsDao.deleteAllWords();
         return null;
     }
 }
}
