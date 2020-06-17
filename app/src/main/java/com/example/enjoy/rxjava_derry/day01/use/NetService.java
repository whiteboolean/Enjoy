package com.example.enjoy.rxjava_derry.day01.use;

import com.example.enjoy.rxjava_derry.day01.bean.LoginBean;
import com.example.enjoy.rxjava_derry.day01.utils.HttpUtils;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class NetService {

    private WanAndroidApi netApi;
    private RequestHelper requestHelper;
    public static volatile NetService instance;

    public static NetService getInstance() {
        if (instance == null) {
            synchronized (NetService.class) {
                if (instance == null) {
                    instance = new NetService();
                }
            }
        }
        return instance;
    }


    private NetService() {
        this.requestHelper = new RequestHelper();
        this.netApi = HttpUtils.getOnlineCookieRetrofit().create(WanAndroidApi.class);
    }

    /**
     * 1.注册接口-S-0928
     */
    public Observable<LoginBean> register(String password, String repassword, String username) {
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("password", password);
        paramsMap.put("repassword", repassword);
        paramsMap.put("username", username);
//        RequestBody body = this.requestHelper.getHttpRequestMap(paramsMap); //使用body
        return netApi.register2(paramsMap).subscribeOn(Schedulers.io());
    }


    /**
     * 2.登录
     */
    public Observable<LoginBean> login(String username, String password) {
        HashMap<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        RequestBody body = this.requestHelper.getHttpRequestMap(params);
        return netApi.login(body).subscribeOn(Schedulers.io());
    }


}
