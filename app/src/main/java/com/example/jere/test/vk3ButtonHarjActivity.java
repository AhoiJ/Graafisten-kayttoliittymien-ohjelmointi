package com.example.jere.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class vk3ButtonHarjActivity extends AppCompatActivity {

    Button btnRed;
    Button btnGreen;
    TextView btnSwing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vk3button);

        btnGreenOnClickListener();
        btnRedOnClickListener();

    }
    public void btnGreenOnClickListener(){
        btnGreen = findViewById(R.id.btnGreen);

        btnGreen.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                btnSwing = findViewById(R.id.btnReactText);
                btnSwing.setText("Vihreä");
                btnSwing.setBackgroundColor(0xFF00FF00);
            }
        });


    }
    public void btnRedOnClickListener(){
        btnRed = findViewById(R.id.btnRed);

        btnRed.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSwing = findViewById(R.id.btnReactText);
                btnSwing.setText("Punainen");
                btnSwing.setBackgroundColor(0xFFFF0000);
            }
        });
    }

}
