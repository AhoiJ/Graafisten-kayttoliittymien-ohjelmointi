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


public class vk5AlarmHarjActivity extends AppCompatActivity {

    private Button mBtTime;
    private Button mBtAlarm;
    private Button mBtSnooze;
    private Button mBtStopAlarm;
    private Button mBtAdd; // add 1 to time
    private Button mBtAddFast; // add as long as button is pressed
    private Button mBtDecrease; // decrease 1 from time
    private Button mBtDecreaseFast; // decrease as long as button is pressed

    private TextView mTxtHours;
    private TextView mTxtMinutes;
    private TextView mTxtSeconds;

    private int hours, minutes, seconds = 0;
    private int REP_DELAY = 50;
    private Handler repeatUpdateHandler = new Handler();

    private boolean mAutoIncrement = false;
    private boolean mAutoDecrement = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vk5alarm);

        btnTimeSetOnClickListener();
        // btnAddSetOnClickListener();

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



    }

    public void btnTimeSetOnClickListener(){
        mBtTime = findViewById(R.id.btnTime);

        mBtTime.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
/*
    public void btnAddSetOnClickListener(){
        mBtAdd = findViewById(R.id.btnIncrease);

        mBtAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    seconds = seconds + 1;
                    if (seconds >= 60) {
                        minutes = minutes + 1;
                        seconds = 0;
                    }
                    if (minutes >= 60){
                        hours = hours + 1;
                        minutes = 0;
                    }
                    if (hours >= 24){
                        hours = 0;
                    }
                    mTxtSeconds = findViewById(R.id.txtSeconds);
                    mTxtSeconds.setText(seconds);
                    mTxtMinutes = findViewById(R.id.txtMinutes);
                    mTxtMinutes.setText(minutes);
                    mTxtHours = findViewById(R.id.txtHours);
                    mTxtHours.setText(hours);


                }

                return false;
            }
        });
    }
*/

    class RptUpdater implements Runnable {
        public void run() {
            if( mAutoIncrement ){
                increment();
                repeatUpdateHandler.postDelayed( new RptUpdater(), REP_DELAY );
            } else if( mAutoDecrement ){
                decrement();
                repeatUpdateHandler.postDelayed( new RptUpdater(), REP_DELAY );
            }
        }
    }

    public void increment(){

        seconds = seconds + 1;
        if (seconds >= 60) {
            minutes = minutes + 1;
            seconds = 0;
        }
        if (minutes >= 60){
            hours = hours + 1;
            minutes = 0;
        }
        if (hours >= 24){
            hours = 0;
        }
        mTxtSeconds = findViewById(R.id.txtSeconds);
        mTxtSeconds.setText("" + seconds);
        mTxtMinutes = findViewById(R.id.txtMinutes);
        mTxtMinutes.setText("" + minutes);
        mTxtHours = findViewById(R.id.txtHours);
        mTxtHours.setText("" + hours);
    }

    public void decrement(){

    }

}
