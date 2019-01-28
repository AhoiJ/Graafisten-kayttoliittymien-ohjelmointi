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
    private int REP_DELAY_FAST = 15;
    private Handler repeatUpdateHandler = new Handler();

    private boolean mAutoIncrement = false;
    private boolean mAutoDecrement = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vk5alarm);

     //   btnTimeSetOnClickListener();

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

    public void btnTimeSetOnClickListener(){
        mBtTime = findViewById(R.id.btnTime);

        mBtTime.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


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
    class RptUpdaterFast implements Runnable {
        public void run() {
            if( mAutoIncrement ){
                increment();
                repeatUpdateHandler.postDelayed( new RptUpdaterFast(), REP_DELAY_FAST );
            } else if( mAutoDecrement ){
                decrement();
                repeatUpdateHandler.postDelayed( new RptUpdaterFast(), REP_DELAY_FAST );
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

        seconds = seconds - 1;
        if (seconds <= 0) {
            minutes = minutes - 1;
            seconds = 60;
        }
        if (minutes < 0){
            hours = hours - 1;
            minutes = 59;
        }
        if (hours < 0){
            hours = 23;
        }
        mTxtSeconds = findViewById(R.id.txtSeconds);
        mTxtSeconds.setText("" + seconds);
        mTxtMinutes = findViewById(R.id.txtMinutes);
        mTxtMinutes.setText("" + minutes);
        mTxtHours = findViewById(R.id.txtHours);
        mTxtHours.setText("" + hours);
    }

}
