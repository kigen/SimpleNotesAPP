package com.kigen.notes.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import com.kigen.notes.models.Note;
import com.kigen.notes.repository.NoteRepository;
import java.util.List;
import javax.inject.Inject;

/**
 * Author: kigen
 * Date: 25/09/2017.
 */

public class NotesListViewModel extends ViewModel {


  private final NoteRepository repository;

  @Inject
  public NotesListViewModel(NoteRepository repository) {
    this.repository = repository;
  }

  public LiveData<List<Note>> getNotes(){
    return repository.getNotes();
  }

}
