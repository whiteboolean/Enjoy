package com.example.enjoy;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

@RunWith(AndroidJUnit4.class)
public class Test3 {



    /**
     * e: 发射器
     */
    @Test
    public void rxTest2() {
        System.out.println("afdsafdsa");
        Observable.just("1") //返回ObserverJust
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        System.out.println("apply");
                        return s + "1";
                    }
                }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("第一个调用");
            }

            @Override
            public void onNext(String s) {
                System.out.println("next");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
