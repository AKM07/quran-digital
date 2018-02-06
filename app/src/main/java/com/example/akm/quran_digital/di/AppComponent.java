package com.example.akm.quran_digital.di;

import android.app.Application;

import com.example.akm.quran_digital.application.QuranDigitalApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by akm on 2/6/18.
 */

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ApplicationModule.class,
        ActivityBuilder.class
})
public interface AppComponent {

    void inject(QuranDigitalApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
