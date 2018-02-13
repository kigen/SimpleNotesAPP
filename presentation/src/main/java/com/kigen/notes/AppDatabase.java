package com.kigen.notes;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import com.kigen.notes.dao.NoteDao;
import com.kigen.notes.models.Note;

/**
 * Author: kigen
 * Date: 22/09/2017.
 */

@Database(entities = { Note.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

   public abstract NoteDao nodeDao();
}
