package com.example.enjoy.reflect;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Deserialize {

    static class Response<T>{

        T data ;
        int code;
        String message;

        public Response(T data, int code, String message) {
            this.data = data;
            this.code = code;
            this.message = message;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "data=" + data +
                    ", code=" + code +
                    ", message='" + message + '\'' +
                    '}';
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


    static class Data{
        String result ;

        public Data(String result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "result='" + result + '\'' +
                    '}';
        }
    }


    static abstract class TypeReference<T>{

        Type type;
        T t;
        TypeReference(){
            Type genericSuperclass = getClass().getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            type = actualTypeArguments[0];
        }

        public Type getType() {
            return type;
        }
    }

    public static void main(String[] args) {
        Response<Data> dataResponse = new Response<>(new Data("数据"),1,"成功");
        Gson gson = new Gson();
        String s = gson.toJson(dataResponse);
        System.out.println(s);

        Type type = new TypeReference<Response<Data>>(){}.getType();

        Response<Data> response = gson.fromJson(s, type);
        System.out.println("=----------");
        System.out.println(response.data.getClass());
    }

}
