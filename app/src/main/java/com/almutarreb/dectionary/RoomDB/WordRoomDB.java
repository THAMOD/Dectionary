package com.almutarreb.dectionary.RoomDB;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.almutarreb.dectionary.Dao.WordsDao;
import com.almutarreb.dectionary.Entities.Words;

@Database(entities = Words.class,version = 1)
public abstract class WordRoomDB extends RoomDatabase {
    private  static WordRoomDB instance;
    public  abstract WordsDao wordsDao();
    //singelton
    public  static synchronized WordRoomDB getInstance(Context context)
    {
        if(instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    WordRoomDB.class,"word-database").fallbackToDestructiveMigration()
                    .addCallback(callback).build();
        }
        return instance;
    }
    private  static RoomDatabase.Callback callback=new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDataAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
    private static class PopulateDataAsyncTask extends AsyncTask<Void,Void, Void>
    {
        private WordsDao mWordsDao;
        PopulateDataAsyncTask(WordRoomDB db)
        {
            mWordsDao = db.wordsDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            mWordsDao.insert(new Words("Book", "كتاب", "noun"));
            mWordsDao.insert(new Words("Car", "سياره", "noun"));
            mWordsDao.insert(new Words("Pen", "قلم", "noun"));
            return null;
        }
    }

}
