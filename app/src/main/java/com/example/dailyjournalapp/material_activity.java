package com.example.dailyjournalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class material_activity extends AppCompatActivity {

    TextView quran;
    TextView hadith;
    TextView books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        quran = findViewById(R.id.quranBody);
        hadith = findViewById(R.id.hadithBody);
        books = findViewById(R.id.bookBody);
        loadactivity();
    }

    private void loadactivity() {
        //quran.setText("http://www.islamicstudies.info/tafheem.php?sura=2&verse=152&verse=157");
        hadith.setText("Abdullah ibn Salam (may Allah be pleased with him) narrated,\n" +
                "When the Prophet arrived for the first time in Madinah, I went with everyone to see him. When I saw\n" +
                "him, I knew his face was not that of a liar. The first words he said were,\n" +
                "“O people: feed the hungry, spread Salam (greeting of peace), maintain your kin relationships, and pray\n" +
                "at night while others are asleep. With this, you shall enter Heaven in peace.” (Al-Bukhari)\n");
        books.setText("Noble Life of the Prophet SA by Dr Ali Muhammad Sallabi\n" +
                "- First Pillar of the New Muslim Society _Masjid - Page 729-754 ( (book page, not PDF page)\n" +
                "- Establishing the Bond of Brotherhood and the Constitution - Page 755-802 (book page, not\n" +
                "PDF page)\n" +
                "- Dealing with People of Other Faith - Page 803-847 (book page, not PDF page)\n" +
                "- Moral and Spiritual Training of the Companions - Page 898-914 (book page, not PDF page)\n" +
                "- Important Events and Legislations - Page 923-944 (book page, not PDF page)");
    }


}