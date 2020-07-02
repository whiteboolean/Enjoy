package com.example.enjoy.rxjava_derry.day0619_annotation_lance;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.enjoy.R;

import java.util.ArrayList;
import java.util.List;

import kotlinx.coroutines.GlobalScope;


@LayoutViewId(R.layout.activity_main5)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.button6)
    Button button;
    @ViewInject(R.id.button7)
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List a = new ArrayList();
//        ViewInjectUtils.injectViewLayout(this);
//        ViewInjectUtils.injectFiledView(this);
//        ViewInjectUtils.injectAutoWired(this);
//        ViewInjectUtils.injectEvents(this);
//
//        button.setText("成功1");
//        button1.setText("成功2");
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });




    }




//    @OnClick(id = {R.id.button6, R.id.button7})
//    public void onClick(View view) {
//        Toast.makeText(this, "点击了", Toast.LENGTH_SHORT).show();
//    }
//
//
//    @OnLongClick(id = {R.id.button6, R.id.button7})
//    public boolean onLongClick(View view) {
//        Toast.makeText(this, "长按了", Toast.LENGTH_SHORT).show();
//        return true;
//    }
}