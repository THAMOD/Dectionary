package com.almutarreb.dectionary.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.almutarreb.dectionary.Entities.Words;
import java.util.List;

@Dao
public interface WordsDao {
    @Insert
    void insert(Words word);

    @Update
    void update(Words word);
    @Delete
    void delete (Words word);
    @Query("delete from wordTable")
    void deleteAllWords();
    @Query("select * from wordTable")
    LiveData<List<Words>> getAllWords();
}
