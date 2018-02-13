package com.kigen.notes.di;

import android.app.Application;
import dagger.Module;
import dagger.Provides;

/**
 * Author: kigen
 * Date: 26/09/2017.
 */

@Module
public class ApplicationModule {

  private final Application application;

  public ApplicationModule(Application application) {
    this.application = application;
  }

  @Provides
  Application provideApplication(){
    return application;
  }
}
