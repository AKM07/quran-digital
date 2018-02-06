package com.example.akm.quran_digital.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.akm.quran_digital.R;
import com.example.akm.quran_digital.entity.Quran;
import com.example.akm.quran_digital.entity.Surah;
import com.example.akm.quran_digital.widget.dialog.base.MessageDialog;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.surah_list)
    RecyclerView surahList;
    @Inject
    Realm realm;

    private ProgressDialog progressDialog;

    private QuranAdapter adapter;
    private List<Surah> surahNameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);
        ButterKnife.bind(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        adapter = new QuranAdapter(this);
        surahList.setLayoutManager(llm);
        surahList.setItemAnimator(new DefaultItemAnimator());
        surahList.setHasFixedSize(true);
        surahList.setAdapter(adapter);

        loadSurahName();
        RealmResults<Quran> qurans = realm.where(Quran.class).findAll();

        if (qurans.size() == 0) {
            loadQuran();
        }
    }

    private void loadQuran() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(getString(R.string.title_wait));
            progressDialog.setCancelable(false);
        }

        if (progressDialog != null && !progressDialog.isShowing()) {
            progressDialog.show();
        }

        realm.executeTransactionAsync(realm -> {
            try {
                InputStream stream = getAssets().open("quran.json");
                realm.createAllFromJson(Quran.class, stream);

                InputStream streamTranslated = getAssets().open("quran_translated.json");
                realm.createAllFromJson(Quran.class, streamTranslated);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, () -> {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }, error -> {
            error.printStackTrace();
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            MessageDialog.getInstance(this)
                    .setTitle(R.string.title_notification)
                    .setMessage(R.string.label_failed_load_data)
                    .showDialog();
        });
    }

    private void loadSurahName() {

        surahNameList.add(new Surah(1, "Al-Fatiha (The Opening)"));
        surahNameList.add(new Surah(2, "Al-Baqarah (The Cow)"));
        surahNameList.add(new Surah(3, "Al-'Imran (The Family of Imran)"));
        surahNameList.add(new Surah(4, "An-Nisa' (The Women)"));
        surahNameList.add(new Surah(5, "Al-Ma'idah (The Table spread with Food)"));
        surahNameList.add(new Surah(6, "Al-An'am (The Cattle)"));
        surahNameList.add(new Surah(7, "Al-A'raf (The Heights)"));
        surahNameList.add(new Surah(8, "Al-Anfal (The Spoils of War)"));
        surahNameList.add(new Surah(9, "At-Taubah (The Repentance)"));
        surahNameList.add(new Surah(10, "Yunus (Jonah)"));
        surahNameList.add(new Surah(11, "Hud (Hud)"));
        surahNameList.add(new Surah(12, "Yusuf (Joseph)"));
        surahNameList.add(new Surah(13, "Ar-Ra'd (The Thunder)"));
        surahNameList.add(new Surah(14, "Ibrahim (Abraham)"));
        surahNameList.add(new Surah(15, "Al-Hijr (The Rocky Tract)"));
        surahNameList.add(new Surah(16, "An-Nahl (The Bees)"));
        surahNameList.add(new Surah(17, "Al-Isra' (The Journey by Night)"));
        surahNameList.add(new Surah(18, "Al-Kahf (The Cave)"));
        surahNameList.add(new Surah(19, "Maryam (Mary)"));
        surahNameList.add(new Surah(20, "Ta-Ha (Ta-Ha)"));
        surahNameList.add(new Surah(21, "Al-Anbiya' (The Prophets)"));
        surahNameList.add(new Surah(22, "Al-Hajj (The Pilgrimage)"));
        surahNameList.add(new Surah(23, "Al-Mu'minun (The Believers)"));
        surahNameList.add(new Surah(24, "An-Nur (The Light)"));
        surahNameList.add(new Surah(25, "Al-Furqan (The Criterion)"));
        surahNameList.add(new Surah(26, "Ash-Shu'ara' (The Poets)"));
        surahNameList.add(new Surah(27, "An-Naml (The Ants)"));
        surahNameList.add(new Surah(28, "Al-Qasas (The Narration)"));
        surahNameList.add(new Surah(29, "Al-'Ankabut (The Spider)"));
        surahNameList.add(new Surah(30, "Ar-Rum (The Romans)"));
        surahNameList.add(new Surah(31, "Luqman (Luqman)"));
        surahNameList.add(new Surah(32, "As-Sajdah (The Prostration)"));
        surahNameList.add(new Surah(33, "Al-Ahzab (The Confederates)"));
        surahNameList.add(new Surah(34, "Saba' (Sheba)"));
        surahNameList.add(new Surah(35, "Fatir (The Originator of Creation)"));
        surahNameList.add(new Surah(36, "Ya-Sin (Ya-Sin)"));
        surahNameList.add(new Surah(37, "As-Saffat (Those Ranged in Ranks)"));
        surahNameList.add(new Surah(38, "Sad (Sad)"));
        surahNameList.add(new Surah(39, "Az-Zumar (The Groups)"));
        surahNameList.add(new Surah(40, "Ghafir (The Forgiver)"));
        surahNameList.add(new Surah(41, "Fussilat (They are explained in detail)"));
        surahNameList.add(new Surah(42, "Ash-Shura (The Consultation)"));
        surahNameList.add(new Surah(43, "Az-Zukhruf (The Gold Adornments)"));
        surahNameList.add(new Surah(44, "Ad-Dukhan (The Smoke)"));
        surahNameList.add(new Surah(45, "Al-Jathiyah (The Kneeling)"));
        surahNameList.add(new Surah(46, "Al-Ahqaf (The Curved Sand-hills)"));
        surahNameList.add(new Surah(47, "Muhammad (Muhammad)"));
        surahNameList.add(new Surah(48, "Al-Fath (The Victory)"));
        surahNameList.add(new Surah(49, "Al-Hujurat (The Dwellings)"));
        surahNameList.add(new Surah(50, "Qaf (Qaf)"));
        surahNameList.add(new Surah(51, "Adh-Dhariyat (The Winds that Scatter)"));
        surahNameList.add(new Surah(52, "At-Tur (The Mount)"));
        surahNameList.add(new Surah(53, "An-Najm (The Star)"));
        surahNameList.add(new Surah(54, "Al-Qamar (The Moon)"));
        surahNameList.add(new Surah(55, "Ar-Rahman (The Most Gracious)"));
        surahNameList.add(new Surah(56, "Al-Waqi'ah (The Event)"));
        surahNameList.add(new Surah(57, "Al-Hadid (The Iron)"));
        surahNameList.add(new Surah(58, "Al-Mujadilah (The Woman who disputes)"));
        surahNameList.add(new Surah(59, "Al-Hashr (The Gathering)"));
        surahNameList.add(new Surah(60, "Al-Mumtahanah (The Woman to be examined)"));
        surahNameList.add(new Surah(61, "As-Saff (The Row)"));
        surahNameList.add(new Surah(62, "Adh-Dhariyat (The Winds that Scatter)"));
        surahNameList.add(new Surah(63, "Al-Munafiqun (The Hypocrites)"));
        surahNameList.add(new Surah(64, "At-Taghabun (Mutual Loss and Gain)"));
        surahNameList.add(new Surah(65, "At-Talaq (The Divorce)"));
        surahNameList.add(new Surah(66, "At-Tahrim (The Prohibition)"));
        surahNameList.add(new Surah(67, "Al-Mulk (Dominion)"));
        surahNameList.add(new Surah(68, "Al-Qalam (The Pen)"));
        surahNameList.add(new Surah(69, "Al-Haqqah (The Inevitable)"));
        surahNameList.add(new Surah(70, "Al-Ma'arij (The Ways of Ascent)"));
        surahNameList.add(new Surah(71, "Nuh (Noah)"));
        surahNameList.add(new Surah(72, "Al-Jinn (The Jinn)"));
        surahNameList.add(new Surah(73, "Al-Muzammil (The One wrapped in Garments)"));
        surahNameList.add(new Surah(74, "Al-Muddaththir (The One Enveloped)"));
        surahNameList.add(new Surah(75, "Al-Qiyamah (The Resurrection)"));
        surahNameList.add(new Surah(76, "Al-Insan (Man)"));
        surahNameList.add(new Surah(77, "Al-Mursalat (Those sent forth)"));
        surahNameList.add(new Surah(78, "An-Naba' (The Great News)"));
        surahNameList.add(new Surah(79, "An-Nazi'at (Those Who Pull Out)"));
        surahNameList.add(new Surah(80, "'Abasa (He Frowned)"));
        surahNameList.add(new Surah(81, "At-Takwir (Winding Round And Losing Its Light)"));
        surahNameList.add(new Surah(82, "Al-Infitar (The Cleaving)"));
        surahNameList.add(new Surah(83, "Al-Mutaffifin (Those Who Deal In Fraud)"));
        surahNameList.add(new Surah(84, "Al-Inshiqaq (The Splitting Asunder)"));
        surahNameList.add(new Surah(85, "Al-Buruj (The Big Stars)"));
        surahNameList.add(new Surah(86, "At-Tariq (The Night Comer)"));
        surahNameList.add(new Surah(87, "Al-A'la (The Most High)"));
        surahNameList.add(new Surah(88, "Al-Ghashiyah (The Overwhelming)"));
        surahNameList.add(new Surah(89, "Al-Fajr (The Break of Day)"));
        surahNameList.add(new Surah(90, "Al-Balad (The City)"));
        surahNameList.add(new Surah(91, "Ash-Shams (The Sun)"));
        surahNameList.add(new Surah(92, "Al-Lail (The Night)"));
        surahNameList.add(new Surah(93, "Ad-Duha (The Forenoon - After Sunrise)"));
        surahNameList.add(new Surah(94, "Ash-Sharh (The Opening Forth)"));
        surahNameList.add(new Surah(95, "At-Tin (The Fig)"));
        surahNameList.add(new Surah(96, "Al-'Alaq (The Clot)"));
        surahNameList.add(new Surah(97, "Al-Qadr (The Night of Decree)"));
        surahNameList.add(new Surah(98, "Al-Baiyyinah (The Clear Evidence)"));
        surahNameList.add(new Surah(99, "Az-Zalzalah (The Earthquake)"));
        surahNameList.add(new Surah(100, "Al-'Adiyat (Those That Run)"));
        surahNameList.add(new Surah(101, "Al-Qari'ah (The Striking Hour)"));
        surahNameList.add(new Surah(102, "At-Takathur (The Piling Up - The Emulous Desire)"));
        surahNameList.add(new Surah(103, "Al-'Asr (The Time)"));
        surahNameList.add(new Surah(104, "Al-Humazah (The Slanderer)"));
        surahNameList.add(new Surah(105, "Al-Fil (The Elephant)"));
        surahNameList.add(new Surah(106, "Quraish (Quraish)"));
        surahNameList.add(new Surah(107, "Al-Ma'un (The Small Kindness)"));
        surahNameList.add(new Surah(108, "Al-Kauthar (A River In Paradise)"));
        surahNameList.add(new Surah(109, "Al-Kafirun (The Disbelievers)"));
        surahNameList.add(new Surah(110, "An-Nasr (The Help)"));
        surahNameList.add(new Surah(111, "Al-Masad (The Palm Fiber)"));
        surahNameList.add(new Surah(112, "Al-Ikhlas (The Purity)"));
        surahNameList.add(new Surah(113, "Al-Falaq (The Daybreak)"));
        surahNameList.add(new Surah(114, "An-Nas (Mankind)"));

        adapter.setSurahList(surahNameList);
    }
}
