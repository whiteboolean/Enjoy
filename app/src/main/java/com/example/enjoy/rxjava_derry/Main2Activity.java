package com.example.enjoy.rxjava_derry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.enjoy.R;
import com.example.enjoy.rxjava_derry.day01.bean.LoginBean;
import com.example.enjoy.rxjava_derry.day01.use.NetService;
import com.example.enjoy.rxjava_derry.day01.use.PageItemBean;
import com.example.enjoy.rxjava_derry.day01.use.ProjectBean;
import com.example.enjoy.rxjava_derry.day01.use.WanAndroidApi;
import com.example.enjoy.rxjava_derry.day01.utils.HttpUtils;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class Main2Activity extends AppCompatActivity {


    private TextView textView2;
    private Button button3;
    private WanAndroidApi androidApi;
    private Button 防抖;
    private NetService netService;
    private Disposable d ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView2 = findViewById(R.id.textView2);
//        button3 = findViewById(R.id.button2);
        防抖 = findViewById(R.id.button3);
        netService = NetService.getInstance() ;



        RxView.clicks(防抖)
                .throttleFirst(2000, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.io())
                .flatMap(new Function<Object, ObservableSource<ProjectBean>>() {
                    @Override
                    public ObservableSource<ProjectBean> apply(Object o) throws Exception {
                        return androidApi.getProject();
                    }
                }).flatMap(new Function<ProjectBean, ObservableSource<ProjectBean.DataBean>>() {
                    @Override
                    public ObservableSource<ProjectBean.DataBean> apply(ProjectBean o) throws Exception {
                        return Observable.fromIterable(o.getData());
                    }
                }).flatMap(new Function<ProjectBean.DataBean, ObservableSource<PageItemBean>>() {
                    @Override
                    public ObservableSource<PageItemBean> apply(ProjectBean.DataBean dataBean) throws Exception {
                        return androidApi.getProjectItem(1,dataBean.getId());
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PageItemBean>() {
                    @Override
                    public void accept(PageItemBean o) throws Exception {
                        textView2.setText(o.getData().getDatas().get(0).getDesc());
                        Toast.makeText(Main2Activity.this, "防抖按钮", Toast.LENGTH_SHORT).show();
                    }
                }).isDisposed();



        androidApi = HttpUtils.getOnlineCookieRetrofit().create(WanAndroidApi.class);
         Disposable disposable ;
        RxView.clicks(防抖)
                .throttleFirst(2000,TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        netService.register("111111","111111","186098112")
                                .observeOn(AndroidSchedulers.mainThread())
                                .doOnNext(new Consumer<LoginBean>() {
                                    @Override
                                    public void accept(LoginBean loginBean) throws Exception {
                                        if (loginBean.getErrorCode()==0){
                                            Toast.makeText(Main2Activity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(Main2Activity.this, loginBean.getErrorMsg(), Toast.LENGTH_SHORT).show();
//                                            loginBean.getErrorMsg()
                                            d.dispose();
                                        }
                                    }
                                })
                                //进行登录操作
                                .observeOn(Schedulers.io())
                                .flatMap(new Function<LoginBean, ObservableSource<LoginBean>>() {
                                    @Override
                                    public ObservableSource<LoginBean> apply(LoginBean loginBean) throws Exception {
                                        return netService.login(loginBean.getData().getUsername(),loginBean.getData().getPassword());
                                    }
                                })
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<LoginBean>() {
                                    @Override
                                    public void onSubscribe(Disposable disposable1) {
                                        d  =disposable1 ;
                                    }

                                    @Override
                                    public void onNext(LoginBean loginBean) {

                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        e.printStackTrace();
                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });

                    }
                }).isDisposed();
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getProjectAction();
                getItemAction();
            }
        });


    }




    public void getProjectAction(){
        androidApi.getProject()//耗时操作 异步线程
                    .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ProjectBean>() {
                    @Override
                    public void accept(ProjectBean projectBean){
                            textView2.setText(projectBean.getData().toString());
                    }
                }).isDisposed();
        }


        public void getItemAction(){

        androidApi.getProjectItem(1,294)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PageItemBean>() {
                    @Override
                    public void accept(PageItemBean pageItemBean) throws Exception {
                        textView2.setText(pageItemBean.getData().getDatas().toString());
                    }
                }).isDisposed();
        }


    private float dp2px(int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}


