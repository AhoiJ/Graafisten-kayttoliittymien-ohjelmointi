package com.example.jere.test;

import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;


public class vk5AlarmHarjActivity extends AppCompatActivity {
// Buttons
    private Button mBtTime; // sets time
    private Button mBtAlarm; // sets alarm
    private Button mBtSnooze;
    private Button mBtStopAlarm;
    private Button mBtAdd; // add 1 to time
    private Button mBtAddFast; // add as long as button is pressed
    private Button mBtDecrease; // decrease 1 from time
    private Button mBtDecreaseFast; // decrease as long as button is pressed
// Textviews
    private TextView mTxtHours;
    private TextView mTxtMinutes;
    private TextView mTxtSeconds;
// ints
    private int hours, minutes, seconds = 0;
    private int REP_DELAY = 50;
    private int REP_DELAY_FAST = 15;
    int alarmHours;
    int alarmMin;
    int alarmSec;

    // handler for thread
    private Handler repeatUpdateHandler = new Handler();
//Timer
    Timer t = new Timer();
// Booleans
    private boolean mAutoIncrement = false;
    private boolean mAutoDecrement = false;
    boolean timeActive = false;
    boolean alarmActive = false;
    boolean snoozeActive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vk5alarm);

        btnTimeSetOnClickListener();
        btnAlarmSetOnClickListener();

        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!timeActive) {
                    int x[];
                    x = increment(hours, minutes, seconds);
                    hours = x[0];
                    minutes = x[1];
                    seconds = x[2];
                    if (alarmActive) {
                        displayTime(alarmHours, alarmMin, alarmSec);
                    }
                    else
                        displayTime(hours, minutes, seconds);
                }

            }
        },0,1000);

        mBtAdd = findViewById(R.id.btnIncrease);
        mBtAdd.setOnLongClickListener(
                new View.OnLongClickListener(){
                    public boolean onLongClick(View v) {
                        mAutoIncrement = true;
                        repeatUpdateHandler.post( new RptUpdater() );
                        return false;
                    }
                }
        );

        mBtAdd.setOnTouchListener( new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if( (event.getAction()==MotionEvent.ACTION_UP || event.getAction()==MotionEvent.ACTION_CANCEL)
                        && mAutoIncrement ){
                    mAutoIncrement = false;
                }
                return false;
            }
        });

        mBtAddFast = findViewById(R.id.btn2Increase);
        mBtAddFast.setOnLongClickListener(
                new View.OnLongClickListener(){
                    public boolean onLongClick(View v) {
                        mAutoIncrement = true;
                        repeatUpdateHandler.post( new RptUpdaterFast() );
                        return false;
                    }
                }
        );

        mBtAddFast.setOnTouchListener( new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if( (event.getAction()==MotionEvent.ACTION_UP || event.getAction()==MotionEvent.ACTION_CANCEL)
                        && mAutoIncrement ){
                    mAutoIncrement = false;
                }
                return false;
            }
        });

        mBtDecrease = findViewById(R.id.btnDecrease);
        mBtDecrease.setOnLongClickListener(
                new View.OnLongClickListener(){
                    public boolean onLongClick(View v) {
                        mAutoDecrement = true;
                        repeatUpdateHandler.post( new RptUpdater() );
                        return false;
                    }
                }
        );

        mBtDecrease.setOnTouchListener( new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if( (event.getAction()==MotionEvent.ACTION_UP || event.getAction()==MotionEvent.ACTION_CANCEL)
                        && mAutoDecrement ){
                    mAutoDecrement = false;
                }
                return false;
            }
        });

        mBtDecreaseFast = findViewById(R.id.btn2Decrease);
        mBtDecreaseFast.setOnLongClickListener(
                new View.OnLongClickListener(){
                    public boolean onLongClick(View v) {
                        mAutoDecrement = true;
                        repeatUpdateHandler.post( new RptUpdaterFast() );
                        return false;
                    }
                }
        );

        mBtDecreaseFast.setOnTouchListener( new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if( (event.getAction()==MotionEvent.ACTION_UP || event.getAction()==MotionEvent.ACTION_CANCEL)
                        && mAutoDecrement ){
                    mAutoDecrement = false;
                }
                return false;
            }
        });



    }
        // Changes what buttons are active and stops timer
    public void btnTimeSetOnClickListener(){
        mBtTime = findViewById(R.id.btnTime);
        mBtTime.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTimeIsActive();
                if(alarmActive)
                    btnAlarmIsActive();
                if (snoozeActive)
                    btnSnoozeIsActive();
            }
        });
    }

    // Changes what buttons are active and sets alarm
    public void btnAlarmSetOnClickListener(){
        mBtAlarm = findViewById(R.id.btnAlarm);
        mBtAlarm.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlarmIsActive();
                if (timeActive)
                    btnTimeIsActive();
                if (snoozeActive)
                    btnSnoozeIsActive();

                    // to show alarm time

            }
        });
    }


    class RptUpdater implements Runnable {
        public void run() {
            if( mAutoIncrement ){
                int[] x;
               if (alarmActive) {
                   x = increment(alarmHours,alarmMin,alarmSec);
                   alarmHours = x[0];
                    alarmMin = x[1];
                    alarmSec = x[2];
                   displayTime(alarmHours,alarmMin, alarmSec);
               } else{
                   x = increment(hours,minutes,seconds);
                   hours = x[0];
                   minutes = x[1];
                   seconds = x[2];
                   displayTime(hours,minutes, seconds);
               }
                repeatUpdateHandler.postDelayed( new RptUpdater(), REP_DELAY );
            } else if( mAutoDecrement ){
                int[] y;
                if (alarmActive) {
                    y = decrement(alarmHours,alarmMin,alarmSec);
                    alarmHours = y[0];
                    alarmMin = y[1];
                    alarmSec = y[2];
                    displayTime(alarmHours,alarmMin, alarmSec);
                } else{
                    y = decrement(hours,minutes,seconds);
                    hours = y[0];
                    minutes = y[1];
                    seconds = y[2];
                    displayTime(hours,minutes, seconds);
                }
                repeatUpdateHandler.postDelayed( new RptUpdater(), REP_DELAY );
            }
        }
    }
    class RptUpdaterFast implements Runnable {
        public void run() {
            if( mAutoIncrement ){
                int[] x;
               if (alarmActive) {
                   x = increment(alarmHours, alarmMin, alarmSec);
                   alarmHours = x[0];
                   alarmMin = x[1];
                   alarmSec = x[2];
                   displayTime(alarmHours,alarmMin, alarmSec);
               }
               else {
                   x = increment(hours,minutes,seconds);
                   hours = x[0];
                   minutes = x[1];
                   seconds = x[2];
                   displayTime(hours,minutes, seconds);
               }
                repeatUpdateHandler.postDelayed( new RptUpdaterFast(), REP_DELAY_FAST );
            } else if( mAutoDecrement ){
                int[] y;
                if (alarmActive) {
                    y = decrement(alarmHours, alarmMin, alarmSec);
                    alarmHours = y[0];
                    alarmMin = y[1];
                    alarmSec = y[2];
                    displayTime(alarmHours,alarmMin,alarmSec);
                }
                else{
                    y = decrement(hours,minutes,seconds);
                    hours = y[0];
                    minutes = y[1];
                    seconds = y[2];
                    displayTime(hours,minutes, seconds);
                }
                repeatUpdateHandler.postDelayed( new RptUpdaterFast(), REP_DELAY_FAST );
            }
        }
    }





    public int[] increment(int h,int m, int s){

        s = s + 1;
        if (s >= 60) {
            m = m + 1;
            s = 0;
        }
        if (m >= 60){
            h = h + 1;
            m = 0;
        }
        if (h >= 24){
            h = 0;
        }

        int[] time;
        time = new int [3];
        time[0] = h;
        time[1] = m;
        time[2] = s;
        return (time);
    }

    public int[] decrement(int h, int m, int s){

        s = s - 1;
        if (s <= 0) {
            m = m - 1;
            s = 60;
        }
        if (m < 0){
            h = h - 1;
            m = 59;
        }
        if (h < 0){
            h = 23;
        }

        int[] time;
        time = new int [3];
        time[0] = h;
        time[1] = m;
        time[2] = s;

        return (time);
    }
    public void displayTime (int h, int m, int s){

        mTxtSeconds = findViewById(R.id.txtSeconds);
        mTxtSeconds.setText("" + s);
        mTxtMinutes = findViewById(R.id.txtMinutes);
        mTxtMinutes.setText("" + m);
        mTxtHours = findViewById(R.id.txtHours);
        mTxtHours.setText("" + h);
    }

    public void btnTimeIsActive(){
        if (timeActive == true) {
            timeActive = false;
            mBtTime.setBackgroundResource(R.drawable.btn_time_inactive);
        }
        else {
            timeActive = true;
            mBtTime.setBackgroundResource(R.drawable.btn_time_active);
        }
    }
    public void btnAlarmIsActive(){
        if (alarmActive){
            alarmActive = false;
            mBtAlarm.setBackgroundResource(R.drawable.btn_alarm_inactive);
        }
        else {
            alarmActive = true;
            mBtAlarm.setBackgroundResource(R.drawable.btn_alarm_active);
        }
    }
    public void btnSnoozeIsActive(){
        if (snoozeActive){
            snoozeActive = false;
            mBtSnooze.setBackgroundResource(R.drawable.btn_alarm_inactive);
        }
        else {
            snoozeActive = true;
            mBtSnooze.setBackgroundResource(R.drawable.btn_snooze_active);
        }
    }
}
