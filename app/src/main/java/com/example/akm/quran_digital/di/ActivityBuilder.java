package com.example.akm.quran_digital.di;

import com.example.akm.quran_digital.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by akm on 2/6/18.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();
}
