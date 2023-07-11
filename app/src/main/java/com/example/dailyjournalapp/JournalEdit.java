package com.example.dailyjournalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.time.LocalTime;

public class JournalEdit extends AppCompatActivity
{
    private EditText editJournal;
    private CheckBox fajr;
    private CheckBox zuhr;
    private CheckBox asr;
    private CheckBox maghrib;
    private CheckBox isha;

    private LocalTime time;

    private boolean one;
    private boolean two;
    private boolean three;
    private boolean four;
    private boolean five;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_edit);
        initWidgets();
        time = LocalTime.now();
    }

    private void initWidgets()
    {
        editJournal = findViewById(R.id.editJournalText);
        fajr = findViewById((R.id.checkBox10));
        zuhr = findViewById((R.id.checkBox9));
        asr = findViewById((R.id.checkBox8));
        maghrib = findViewById((R.id.checkBox7));
        isha = findViewById((R.id.checkBox6));
    }

    private void check(){
        if(fajr.isChecked())
            one = true;
        if(zuhr.isChecked())
            two = true;
        if(asr.isChecked())
            three = true;
        if(maghrib.isChecked())
            four = true;
        if(isha.isChecked())
            five = true;
    }



    public void saveJournalAction(View view)
    {
        String JournalName = editJournal.getText().toString();
        check();
        Journal newJournal = new Journal(JournalName, CalendarUtils.selectedDate,one,two,three,four,five);
        Journal.JournalsList.add(newJournal);
        finish();
    }
}