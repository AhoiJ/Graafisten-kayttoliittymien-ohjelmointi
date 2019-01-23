package com.example.jere.test;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;


public class vk5AlarmHarjActivity extends AppCompatActivity {

    private Button mBtTime;
    private Button mBtAlarm;
    private Button mBtSnooze;
    private Button mBtStopAlarm;
    private Button mBtAdd; // add 1 to time
    private Button mBtAddHold; // add as long as button is pressed
    private Button mBtDecrease; // decrease 1 from time
    private Button mBtDecreaseHold; // decrease as long as button is pressed

    private EditText editHours;
    private EditText editMinutes;
    private EditText editSeconds;

    private int hours, minutes, seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vk5alarm);
/*
        SharedPreferences timeH = getSharedPreferences(hours,0);
        SharedPreferences timeM = getSharedPreferences(minutes, 0);
        SharedPreferences timeS = getSharedPreferences(seconds, 0);

        timeH.edit().putString("hours", hours);
        timeM.edit().putString("minutes", minutes);
        timeS.edit().putString("seconds", seconds);
*/
        btnTimeSetOnClickListener();
        btnAddSetOnClickListener();

    }

    public void btnTimeSetOnClickListener(){
        mBtTime = findViewById(R.id.btnTime);

        mBtTime.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void btnAddSetOnClickListener(){


    }
}
