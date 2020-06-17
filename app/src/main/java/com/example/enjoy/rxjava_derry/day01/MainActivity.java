package com.example.enjoy.rxjava_derry.day01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.enjoy.R;

public class MainActivity extends AppCompatActivity {

    private  View view;
    private  View view1;
    private  View view2;
    private  View view3;
    private  View view4;
    private  View view5;
    private  View view6;
    private  View view7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        view = new View(this);
        view1 = new View(this);
        view2 = new View(this);
        view3 = new View(this);
        view4 = new View(this);
        view5 = new View(this);
        view6 = new View(this);
        view7 = new View(this);
    }
}