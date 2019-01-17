package com.example.jere.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    private Button mBtVkTeht1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtVkTeht1OnClickListener();


    }

    public void mBtVkTeht1OnClickListener() {

        mBtVkTeht1 = findViewById(R.id.btnVkT1);
        mBtVkTeht1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                launchVkTeht1();
            }
        });
    }


    private void launchVkTeht1() {
        Intent intent = new Intent(this, vk3ButtonHarjActivity.class);
        startActivity(intent);
    }

}
