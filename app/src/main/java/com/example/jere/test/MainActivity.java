package com.example.jere.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    private Button mBtVkTeht3;
    private Button mBtVkTeht4;
    private Button mBtVkTeht5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtVk3TehtOnClickListener();
        mBtVk4TehtOnClickListener();
        mbtVk5TehtOnCLickListener();

    }

    public void mBtVk3TehtOnClickListener() {
        mBtVkTeht3 = findViewById(R.id.btnVkT3);
        mBtVkTeht3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                launchVkTeht3();
            }
        });
    }

    public void mBtVk4TehtOnClickListener(){
        mBtVkTeht4 = findViewById(R.id.btnVkT4);
        mBtVkTeht4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                launchVkTeht4();
            }
        });
    }

    public void mbtVk5TehtOnCLickListener(){
        mBtVkTeht5 = findViewById(R.id.btnVkT5);
        mBtVkTeht5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                launchVkTeht5 ();
            }
        });

    }


    private void launchVkTeht3() {
        Intent intent = new Intent(this, vk3ButtonHarjActivity.class);
        startActivity(intent);
    }

    private void launchVkTeht4(){
        Intent intent = new Intent(this, vk4ButtonHarjActivity.class);
        startActivity(intent);
    }

    private void launchVkTeht5() {
        Intent intent = new Intent(this, vk5AlarmHarjActivity.class);
        startActivity(intent);
    }
}
