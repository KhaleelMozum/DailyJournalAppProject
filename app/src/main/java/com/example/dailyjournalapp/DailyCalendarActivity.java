package com.example.dailyjournalapp;

import static com.example.dailyjournalapp.CalendarUtils.selectedDate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DailyCalendarActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener
{
    private CheckBox fajr;
    private CheckBox zuhr;
    private CheckBox asr;
    private CheckBox maghrib;
    private CheckBox isha;
    private EditText personal;
    private TextView monthDayText;
    private TextView dayOfWeekTV;
    private ListView eventListView;
    private RecyclerView calendarRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_calendar);
        initWidgets();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initWidgets()
    {
        monthDayText = findViewById(R.id.monthDayText);
        dayOfWeekTV = findViewById(R.id.dayOfWeekTV);
        eventListView = findViewById(R.id.eventListView);

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setDayView();
    }

    private void setDayView()
    {

        monthDayText.setText(CalendarUtils.monthDayFromDate(selectedDate));
        String dayOfWeek = selectedDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
        dayOfWeekTV.setText(dayOfWeek);

        setJournalAdapter();

    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        CalendarUtils.selectedDate = date;
        setDayView();
    }

    public void previousDayAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusDays(1);
        setDayView();
    }

    public void nextDayAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusDays(1);
        setDayView();
    }

    private void setJournalAdapter()
    {
        ArrayList<Journal> dailyJournals = Journal.JournalsForDate(CalendarUtils.selectedDate);
        JournalAdapter journalAdapter = new JournalAdapter(getApplicationContext(), dailyJournals);
        eventListView.setAdapter(journalAdapter);
    }

    public void newJournalAction (View v)
    {
        Intent i = new Intent(this, JournalEdit.class);
        startActivity(i);
    }

}