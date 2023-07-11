package com.example.dailyjournalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class JournalAdapter extends ArrayAdapter<Journal>
{
    public JournalAdapter(@NonNull Context context, List<Journal> Journals)
    {
        super(context, 0, Journals);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Journal journal = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.journal_cell, parent, false);

        TextView fajr = convertView.findViewById(R.id.checkBox);
        TextView zuhr = convertView.findViewById(R.id.checkBox2);
        TextView asr = convertView.findViewById(R.id.checkBox3);
        TextView maghrib = convertView.findViewById(R.id.checkBox4);
        TextView isha = convertView.findViewById(R.id.checkBox5);
        TextView journalBody = convertView.findViewById(R.id.editTextText2);

        String JournalTitle = journal.getPersonal();
        journalBody.setText(JournalTitle);

        boolean prayer_one = journal.isFajr();
        boolean prayer_two = journal.isZuhr();
        boolean prayer_three = journal.isAsr();
        boolean prayer_four = journal.isMaghrib();
        boolean prayer_five = journal.isIsha();

        if(prayer_one){
            fajr.setText("Fajr: Completed");
        }

        if(prayer_two){
            zuhr.setText("Zuhr: Completed");
        }

        if(prayer_three){
            asr.setText("Asr: Completed");
        }

        if(prayer_four){
            maghrib.setText("Maghrib: Completed");
        }

        if(prayer_five){
            isha.setText("Isha: Completed");
        }


        return convertView;
    }
}