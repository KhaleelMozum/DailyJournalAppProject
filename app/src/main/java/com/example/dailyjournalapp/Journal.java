package com.example.dailyjournalapp;

import android.widget.EditText;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class Journal {

    private boolean fajr;
    private boolean zuhr;
    private boolean asr;
    private boolean maghrib;
    private boolean isha;
    private String personal;
    public static ArrayList<Journal> JournalsList = new ArrayList<>();

    public static ArrayList<Journal> JournalsForDate(LocalDate date)
    {
        ArrayList<Journal> journals = new ArrayList<>();

        for(Journal journal : JournalsList)
        {
            if(journal.getDate().equals(date))
                journals.add(journal);
        }

        return journals;
    }

    private String name;
    private LocalDate date;
    private LocalTime time;

    public Journal(String personal, LocalDate date, boolean fajr,boolean zuhr,boolean asr,boolean maghrib,boolean isha)
    {
        this.personal = personal;
        this.date = date;
        this.fajr = fajr;
        this.zuhr = zuhr;
        this.asr = asr;
        this.maghrib = maghrib;
        this.isha = isha;
    }


    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;

    }

    public boolean isZuhr() {
        return zuhr;
    }

    public void setZuhr(boolean zuhr) {
        this.zuhr = zuhr;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }
    public boolean isFajr() {
        return fajr;
    }

    public void setFajr(boolean fajr) {
        this.fajr = fajr;
    }
    public boolean isMaghrib() {
        return maghrib;
    }

    public void setMaghrib(boolean maghrib) {
        this.maghrib = maghrib;
    }
    public boolean isIsha() {
        return isha;
    }

    public void setIsha(boolean isha) {
        this.isha = isha;
    }
    public boolean isAsr() {
        return asr;
    }

    public void setAsr(boolean asr) {
        this.asr = asr;
    }
}
