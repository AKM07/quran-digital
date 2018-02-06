package com.example.akm.quran_digital.application;

import android.app.Activity;
import android.app.Application;

import com.example.akm.quran_digital.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by akm on 2/6/18.
 */

public class QuranDigitalApplication extends Application implements HasActivityInjector {

    private static QuranDigitalApplication instance;

    public QuranDigitalApplication() {
        instance = this;
    }

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;


    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();
        initRealm();
    }

    public void initDagger() {
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    public void initRealm() {
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("quran_digital.realm")
                .schemaVersion(0)
//                .migration(new RealmMigrations())
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(configuration);
    }

    public static QuranDigitalApplication getInstance() {
        return instance;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
