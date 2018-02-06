package com.example.akm.quran_digital.quran;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.akm.quran_digital.R;
import com.example.akm.quran_digital.entity.Quran;
import com.example.akm.quran_digital.entity.Verses;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by akm on 2/6/18.
 */

public class ReadQuranActivity extends AppCompatActivity {

    @BindView(R.id.verse_list)
    RecyclerView verseList;
    @Inject
    Realm realm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_quran);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);

        int suraId = getIntent().getIntExtra("suraId", 0);
        String suraName = getIntent().getStringExtra("suraName");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(suraName);
        }

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        ReadQuranAdapter adapter = new ReadQuranAdapter(this);
        verseList.setLayoutManager(llm);
        verseList.setItemAnimator(new DefaultItemAnimator());
        verseList.setHasFixedSize(true);
        verseList.setAdapter(adapter);

        RealmResults<Quran> qurans = realm.where(Quran.class)
                .equalTo("DatabaseID", 1)
                .and()
                .equalTo("SuraID", suraId).findAll();

        RealmResults<Quran> translationQurans = realm.where(Quran.class)
                .equalTo("DatabaseID", 68)
                .and()
                .equalTo("SuraID", suraId).findAll();

        for (Quran quran : qurans) {
            Verses verses = new Verses();
            verses.setVerseText(quran.getAyahText());
            adapter.addVerses(verses);
        }

        for (Quran quranTranslated : translationQurans) {
            Verses verses = new Verses();
            verses.setVerseTranslation(quranTranslated.getAyahText());
            adapter.addTranslationVerses(verses);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
