package com.kigen.notes.di;

import android.app.Application;
import com.kigen.notes.dao.NoteDao;
import com.kigen.notes.repository.NoteRepository;
import com.kigen.notes.ui.AddNoteActivity;
import com.kigen.notes.ui.AddNoteViewModel;
import com.kigen.notes.ui.MainActivity;
import com.kigen.notes.ui.NotesListViewModel;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Author: kigen
 * Date: 26/09/2017.
 */

@Singleton
@Component(modules = {NotesModule.class, ApplicationModule.class})
public interface NotesComponent {

  void inject(MainActivity mainActivity);
  void inject(AddNoteActivity addNoteActivity);

  NoteRepository providesNotesRepo();

  NoteDao providesNoteDao();

  AddNoteViewModel providesAddNoteViewModel();

  NotesListViewModel providesNotesListViewModel();

  Application providesApplication();

}
