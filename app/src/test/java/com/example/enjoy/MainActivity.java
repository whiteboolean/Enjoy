package com.example.enjoy;

import androidx.annotation.IntDef;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解与反射
 *
 * https://www.jianshu.com/p/9be58ee20dee //反射
 */

@Ray(value = 1,id = 1)
public class MainActivity extends AppCompatActivity {

    public static final int A = 10;
    public static final int B = 20;

    @InjectView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectUtils.injectView(this);
        textView.setText("哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        setParams(A);
    }


    public void setParams(@LimitedAno int a){
        System.out.println(a);
    }

//
//    @IntDef({A,B})
//    @Target({ElementType.PARAMETER,ElementType.FIELD})
//    @Retention(RetentionPolicy.CLASS)
//    public @interface LimiteAno(){
//
//    }

}
