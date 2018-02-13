package com.kigen.notes.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.kigen.notes.models.Note;
import java.util.List;

/**
 * Author: kigen
 * Date: 22/09/2017.
 */

@Dao
public interface NoteDao {

  @Query("SELECT * FROM NOTE")
  LiveData<List<Note>> getAllNotes();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
   void insertNotes(Note... notes);
}
