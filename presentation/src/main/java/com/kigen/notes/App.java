package com.kigen.notes;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.kigen.notes.di.ApplicationModule;
import com.kigen.notes.di.DaggerNotesComponent;
import com.kigen.notes.di.NotesComponent;
import com.kigen.notes.di.NotesModule;

/**
 * Author: kigen
 * Date: 22/09/2017.
 */

public class App extends Application {

  private NotesComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();

    applicationComponent = DaggerNotesComponent
        .builder()
        .applicationModule(new ApplicationModule(this))
        .notesModule(new NotesModule(this))
        .build();

     Stetho.initializeWithDefaults(this);
  }

  public NotesComponent getApplicationComponent() {
    return applicationComponent;
  }
}
