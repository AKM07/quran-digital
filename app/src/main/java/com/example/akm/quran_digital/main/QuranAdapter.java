package com.example.akm.quran_digital.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akm.quran_digital.R;
import com.example.akm.quran_digital.entity.Surah;
import com.example.akm.quran_digital.quran.ReadQuranActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by akm on 2/6/18.
 */

public class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.QuranViewHolder>  {


    private Context context;

    private List<Surah> surahList = new ArrayList<>();

    public QuranAdapter(Context context) {
        this.context = context;
    }
    @Override
    public QuranViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_quran, parent, false);

        return new QuranViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QuranViewHolder holder, int position) {
        Surah surah = surahList.get(position);
        holder.surahTitle.setText(surah.getName());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ReadQuranActivity.class);
            intent.putExtra("suraId", surah.getId());
            intent.putExtra("suraName", surah.getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return surahList.size();
    }

    public class QuranViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tittle_surah)
        public TextView surahTitle;

        public QuranViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setSurahList(List<Surah> quranModelList) {
        surahList.addAll(quranModelList);
    }
}
