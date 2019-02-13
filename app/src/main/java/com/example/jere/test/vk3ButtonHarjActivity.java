package com.example.jere.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class vk3ButtonHarjActivity extends AppCompatActivity {

    private Button mBtStart;
    private Button mBtStop;
    private Button mBtSuurenna;
    private Button mBtPienenna;

    private TextView mTxTStatus;
    private TextView mTxTZoom;

    int zoom = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vk3button);

        mTxTStatus = findViewById(R.id.txtStatus);

        mBtStart = findViewById(R.id.btnStarted);
        mBtStartSetOnClickListener();

        mBtStop = findViewById(R.id.btnStopped);
        mBtStopSetOnClickListener();

        mBtSuurenna = findViewById(R.id.btnSuurenna);
        mBtSuurennaSetOnClickListener();

        mBtPienenna = findViewById(R.id.btnPienenna);
        mBtPienennaSetOnClickListener();

        mTxTZoom = findViewById(R.id.txtZoom);
    }

    public void mBtStartSetOnClickListener () {
        mBtStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTxTStatus.setText(R.string.Started_txt);
            }
        });

    }
    public void mBtStopSetOnClickListener(){
        mBtStop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTxTStatus.setText(R.string.Stopped_txt);
            }
        });

    }

    public void mBtSuurennaSetOnClickListener(){
        mBtSuurenna.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                zoom++;
                mTxTZoom.setText("ZOOM = " + zoom);
            }
        });
    }

    public void mBtPienennaSetOnClickListener(){
        mBtPienenna.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                zoom--;
                mTxTZoom.setText("ZOOM = " + zoom);
            }
        });
    }

}
