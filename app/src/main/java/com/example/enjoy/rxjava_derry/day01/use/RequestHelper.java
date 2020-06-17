package com.example.enjoy.rxjava_derry.day01.use;

import com.google.gson.Gson;

import java.util.HashMap;

import okhttp3.RequestBody;


public class RequestHelper {

    private static Gson gson = new Gson();

    public RequestBody getHttpRequestMap(HashMap<String, String> paramsMap) {
        String strEntity = gson.toJson(paramsMap);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"),strEntity);
        return body;
    }

}
