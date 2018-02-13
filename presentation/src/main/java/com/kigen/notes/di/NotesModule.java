package com.kigen.notes.di;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;
import com.kigen.notes.AppDatabase;
import com.kigen.notes.dao.NoteDao;
import com.kigen.notes.repository.NoteRepository;
import com.kigen.notes.ui.AddNoteViewModel;
import com.kigen.notes.ui.NotesListViewModel;
import com.kigen.notes.ui.factory.CommonViewModelFactory;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Author: kigen
 * Date: 26/09/2017.
 */

@Module
public class NotesModule {

  private final AppDatabase database;

  public NotesModule(Application application){
      database= Room.databaseBuilder(
          application,
          AppDatabase.class,
          "notes_db"
      ).build();
  }

  @Provides
  @Singleton
   NoteRepository provideNotesRepository(NoteDao noteDao){
    return new NoteRepository(noteDao);
  }

  @Provides
  @Singleton
   NoteDao providesNotesDao(AppDatabase database){
    return database.nodeDao();
  }

  @Provides
  @Singleton
  AppDatabase provideDatabase(){
    return database;
  }

  @Singleton
  @Provides
   AddNoteViewModel providesAddNoteViewModel(NoteRepository repository){
    return  new AddNoteViewModel(repository);
  }

  @Singleton
  @Provides
  NotesListViewModel providesNotesListViewModel(NoteRepository repository){
  return new NotesListViewModel(repository);
  }


}
