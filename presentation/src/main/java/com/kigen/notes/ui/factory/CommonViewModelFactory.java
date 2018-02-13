package com.kigen.notes.ui.factory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import com.kigen.notes.repository.NoteRepository;
import com.kigen.notes.ui.AddNoteViewModel;
import com.kigen.notes.ui.NotesListViewModel;

/**
 * Author: kigen
 * Date: 26/09/2017.
 */

public class CommonViewModelFactory implements ViewModelProvider.Factory {
  private final NoteRepository repository;

  public CommonViewModelFactory(NoteRepository repository) {
    this.repository = repository;
  }

  @Override public <T extends ViewModel> T create(Class<T> modelClass) {

    if(modelClass.isAssignableFrom(AddNoteViewModel.class)){
      return (T) new AddNoteViewModel(repository);
    }
    else if (modelClass.isAssignableFrom(NotesListViewModel.class)){
      return (T) new NotesListViewModel(repository);
    }else {
      throw new IllegalArgumentException("ViewModel not found");
    }

  }
}
