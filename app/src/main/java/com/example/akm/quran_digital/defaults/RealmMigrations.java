package com.example.akm.quran_digital.defaults;

import android.support.annotation.NonNull;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by AKM on 1/30/18.
 */

public class RealmMigrations implements RealmMigration {
    @Override
    public void migrate(@NonNull DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();

//        if (oldVersion == 0) {
//            schema
//        }
    }
}
