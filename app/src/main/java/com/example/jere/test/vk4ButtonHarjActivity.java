package com.example.jere.test;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class vk4ButtonHarjActivity extends AppCompatActivity {
    /*
              TÄMÄ ON VIIKKOTEHTÄVÄ 3, FM RADIO!!!!!
   */
    // Initialize buttons
    private Button mBtArrowRight;
    private Button mBtArrowLeft;
    private Button mBtArrowRightLong;
    private Button getmBtArrowLeftLong;

    // Initialize radio buttons
    private RadioButton rbCh1;
    private RadioButton rbCh2;
    private RadioButton rbCh3;
    private RadioButton rbOff;

    // Initialize radiogroup
    RadioGroup channelGroup;

    // Initialize TextView
    private TextView txtFrequenzy;

    // Initialize seekBar
    private SeekBar radioSlider;

    // Variables
    private float ch1Freq, ch2Freq, ch3Freq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vk4button);

        channelGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rbCh1 = findViewById(R.id.radioCH1);
        rbCh2 = findViewById(R.id.radioCH2);
        rbCh3 = findViewById(R.id.radioCH3);
        rbOff = findViewById(R.id.radioOff);

        channelGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int getCh = whatChannel();
                ch1Freq = getCh1Value();
                ch2Freq = getCh2Value();
                ch3Freq = getCh3Value();
                radioSlider.setEnabled(true);

                if (getCh == 1){
                //    radioSlider.setProgress((int)ch1Freq);
                    txtFrequenzy.setText(ch1Freq + " Mhz");
                }else if (getCh == 2){
                 //   radioSlider.setProgress((int)ch2Freq);
                    txtFrequenzy.setText(ch2Freq + " Mhz");
                }else if (getCh == 3){
                 //   radioSlider.setProgress((int)ch3Freq);
                    txtFrequenzy.setText(ch3Freq + " Mhz");
                }
                else if(getCh == 0){
                    radioSlider.setEnabled(false);
                }
            }
        });

        seekBarFunc();

    }

    public void seekBarFunc() {

        radioSlider = (SeekBar) findViewById(R.id.sBRadioSlider);
        txtFrequenzy = (TextView) findViewById(R.id.txtFrequenzy);

        radioSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 int getCh = whatChannel();
                if (getCh == 1){
                    ch1Freq = 87 + (float) progress / 10;
                    txtFrequenzy.setText(ch1Freq + " Mhz");
                    saveVariables(ch1Freq,ch2Freq,ch3Freq);
                }else if (getCh == 2){
                    ch2Freq = 87 + (float) progress / 10;
                    txtFrequenzy.setText(ch2Freq + " Mhz");
                    saveVariables(ch1Freq,ch2Freq,ch3Freq);
                }else if (getCh == 3){
                    ch3Freq = 87 + (float) progress / 10;
                    txtFrequenzy.setText(ch3Freq + " Mhz");
                    saveVariables(ch1Freq,ch2Freq,ch3Freq);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                saveVariables(ch1Freq,ch2Freq,ch3Freq);
            }
        });
    }

    public int whatChannel() {
        int channelSelected = -1;
        if (rbCh1.isChecked()) {
            channelSelected = 1;
        } else if (rbCh2.isChecked()) {
            channelSelected = 2;
        } else if (rbCh3.isChecked()) {
            channelSelected = 3;
        } else if (rbOff.isChecked()) {
            channelSelected = 0;
        }
        return channelSelected;
    }

    public void saveVariables(float ch1Value, float ch2Value, float ch3Value) {
        // Create object of SharedPreferences.
        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        //now get Editor
        SharedPreferences.Editor editor= sharedPref.edit();
        //put your value
        editor.putFloat("ch1Value", ch1Value);
        editor.putFloat("ch2Value", ch2Value);
        editor.putFloat("ch3Value", ch3Value);
        //commits your edits
        editor.commit();

    }

    public float getCh1Value() {
        // get channel value
        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        Float ch1Value = sharedPref.getFloat("ch1Value", 0);
        return ch1Value;
    }
    public float getCh2Value() {
        // get channel value
        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        Float ch2Value = sharedPref.getFloat("ch2Value", 0);
        return ch2Value;
    }
    public float getCh3Value() {
        // get channel value
        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        Float ch3Value = sharedPref.getFloat("ch3Value", 0);
        return ch3Value;
    }
}
