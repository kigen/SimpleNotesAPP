package com.kigen.notes.presentation;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import com.kigen.notes.AppDatabase;
import com.kigen.notes.models.Note;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Author: kigen
 * Date: 25/09/2017.
 */

@RunWith(AndroidJUnit4.class)
public class  NotesDaoTest {

  private AppDatabase database;


  private String TITLE1 = "My Note 1";
  private String CONTENT = "This is the content of all items";
  private String AUTHOR ="kigen";

  private Note NOTE1  = new Note(TITLE1,CONTENT,AUTHOR);
  private Note NOTE2  = new Note(TITLE1,CONTENT,AUTHOR);

  @Before
  public void initDb() throws Exception {
    database = Room.inMemoryDatabaseBuilder(
        InstrumentationRegistry.getContext(),
        AppDatabase.class)
        // allowing main thread queries, just for testing
        .allowMainThreadQueries()
        .build();
  }

  @Test
  public void InsertAndQueryNotes(){
    database.nodeDao().insertNotes(NOTE1,NOTE2);
    //database.nodeDao().getAllNotes().count().test().assertValueCount(2);

  }


  @Test



  @After
  public void closeDb() throws Exception {
    database.close();
  }

}
