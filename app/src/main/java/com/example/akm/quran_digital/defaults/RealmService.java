package com.example.akm.quran_digital.defaults;

import io.realm.Realm;

/**
 * Created by akm on 2/6/18.
 */

public class RealmService {

    private final Realm mRealm;

    public RealmService(Realm realm) {
        mRealm = realm;
    }

    public void closeRealm() {
        mRealm.close();
    }
}
