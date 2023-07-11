package com.example.dailyjournalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

public class times_activity extends AppCompatActivity implements View.OnClickListener {


    TextView masjid;
    TextView fajr, zuhr, asr, maghrib, isha;
    Button next;
    int currentMasjidIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        masjid = findViewById(R.id.masjid);
        fajr = findViewById(R.id.fajrTime);
        zuhr = findViewById(R.id.zuhrTime);
        asr = findViewById(R.id.asrTime);
        maghrib = findViewById(R.id.maghribTime);
        isha = findViewById(R.id.ishaTime);
        next = findViewById(R.id.button3);


        next.setOnClickListener(this);

        loadNewTime();

    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.button3){
            currentMasjidIndex++;
            loadNewTime();
        }
    }

    void loadNewTime() {

        if(currentMasjidIndex == 4 ){
            restart();
            return;
        }
        masjid.setText(PrayerTimes.masjid[currentMasjidIndex]);
        fajr.setText(PrayerTimes.prayerTimes[0][currentMasjidIndex]);
        zuhr.setText(PrayerTimes.prayerTimes[1][currentMasjidIndex]);
        asr.setText(PrayerTimes.prayerTimes[2][currentMasjidIndex]);
        maghrib.setText(PrayerTimes.prayerTimes[3][currentMasjidIndex]);
        isha.setText(PrayerTimes.prayerTimes[4][currentMasjidIndex]);
    }

    void restart() {
        currentMasjidIndex = 0;
        loadNewTime();
    }


}