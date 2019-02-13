package com.example.jere.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class vk4ButtonHarjActivity extends AppCompatActivity {

    Button plusOne;
    Button plusTen;
    Button minusOne;
    Button minusTen;
    Button reset;
    TextView tsxValue;
    int harjValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vk4button);
/*

            TÄMÄ ON VIIKKOTEHTÄVÄ 3, FM RADIO!!!!!

 */
        mBtPlusOneOnClickListener();
        mBtPlusTenOnClickListener();
        mBtMinusOneOnClickListener();
        mBtMinusTenOnClickListener();
        mBtResetOnClickListener();
    }

    public void mBtPlusOneOnClickListener(){
        plusOne = findViewById(R.id.btn_plusOne);

        plusOne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                harjValue = harjValue + 1;
                tsxValue = findViewById(R.id.text_showValue);
                tsxValue.setText("" + harjValue);
            }
        });
    }
    public void mBtPlusTenOnClickListener(){
        plusTen = findViewById(R.id.btn_plusTen);

        plusTen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                harjValue = harjValue + 10;
                tsxValue = findViewById(R.id.text_showValue);
                tsxValue.setText("" + harjValue);
            }
        });
    }
    public void mBtMinusOneOnClickListener(){
        minusOne = findViewById(R.id.btn_minusOne);

        minusOne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                harjValue = harjValue - 1;
                tsxValue = findViewById(R.id.text_showValue);
                tsxValue.setText("" + harjValue);
            }
        });
    }
    public void mBtMinusTenOnClickListener(){
        minusTen = findViewById(R.id.btn_minusTen);

        minusTen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                harjValue = harjValue - 10;
                tsxValue = findViewById(R.id.text_showValue);
                tsxValue.setText("" + harjValue);
            }
        });
    }
    public void mBtResetOnClickListener(){
        reset = findViewById(R.id.btn_reset);

        reset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                harjValue = 0;
                tsxValue = findViewById(R.id.text_showValue);
                tsxValue.setText("" + harjValue);
            }
        });
    }
}
