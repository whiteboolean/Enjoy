package com.example.enjoy.rxjava_derry.day01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;

import android.os.Bundle;
import android.widget.SeekBar;

import com.example.enjoy.R;
import com.frame.july_myview.zero_custom_view.MyTextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        MyTextView viewById = findViewById(R.id.myTextView);

        AppCompatSeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                float percent = Float.parseFloat(String.valueOf(progress)) / 100;

                System.out.println("percent:"+percent);
                viewById.setPercents(percent);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}