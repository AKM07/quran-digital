package com.example.akm.quran_digital.quran;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akm.quran_digital.R;
import com.example.akm.quran_digital.entity.Verses;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by akm on 2/6/18.
 */

public class ReadQuranAdapter extends RecyclerView.Adapter<ReadQuranAdapter.ReadQuranViewHolder> {

    private Activity activity;
    private List<Verses> versesList = new ArrayList<>();
    private List<Verses> translationVersesList = new ArrayList<>();

    public ReadQuranAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ReadQuranViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_read_quran, parent, false);

        return new ReadQuranViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ReadQuranViewHolder holder, int position) {
        Verses verses = versesList.get(position);
        Verses translationVerses = translationVersesList.get(position);

        holder.verseCounterLabel.setText(String.valueOf(position + 1));
        holder.verseTextLabel.setText(verses.getVerseText());
        holder.verseTranslationLabel.setText(translationVerses.getVerseTranslation());
    }

    @Override
    public int getItemCount() {
        return versesList.size();
    }

    public class ReadQuranViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.verse_counter_label)
        TextView verseCounterLabel;
        @BindView(R.id.verse_text_label)
        TextView verseTextLabel;
        @BindView(R.id.verse_translation_label)
        TextView verseTranslationLabel;

        public ReadQuranViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void addVerses(Verses verses) {
        versesList.add(verses);
        notifyDataSetChanged();
    }

    public void addTranslationVerses(Verses translationVerses) {
        translationVersesList.add(translationVerses);
        notifyDataSetChanged();
    }
}
