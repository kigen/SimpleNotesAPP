package com.kigen.notes.repository;

import android.arch.lifecycle.LiveData;
import com.kigen.notes.dao.NoteDao;
import com.kigen.notes.models.Note;
import java.util.List;
import javax.inject.Inject;

/**
 * Author: kigen
 * Date: 26/09/2017.
 */

public class NoteRepository {

  private  final NoteDao noteDao;

  @Inject
  public  NoteRepository(NoteDao  noteDao){
    this.noteDao =noteDao;
  }

  public LiveData<List<Note>> getNotes(){
    return noteDao.getAllNotes();
  }

  public void insertNote(Note note){
    noteDao.insertNotes(note);
  }

}
