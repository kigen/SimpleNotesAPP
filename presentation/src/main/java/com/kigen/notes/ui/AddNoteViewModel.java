package com.kigen.notes.ui;

import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import com.kigen.notes.models.Note;
import com.kigen.notes.repository.NoteRepository;
import javax.inject.Inject;

/**
 * Author: kigen
 * Date: 26/09/2017.
 */

public class AddNoteViewModel extends ViewModel {

  private final NoteRepository repository;

  @Inject
  public AddNoteViewModel(NoteRepository repository) {
    this.repository = repository;
  }

  public void addNote(Note note){
    new AddNoteTask().execute(note);
  }
  private class AddNoteTask extends AsyncTask<Note,Void,Void>{

    @Override protected Void doInBackground(Note... params) {
      repository.insertNote(params[0]);
      return null;
    }
  }


}
