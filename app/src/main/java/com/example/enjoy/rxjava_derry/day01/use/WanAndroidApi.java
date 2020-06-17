package com.example.enjoy.rxjava_derry.day01.use;

import com.example.enjoy.rxjava_derry.day01.bean.LoginBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WanAndroidApi {

    //总数据
    @GET("project/tree/json")
    Observable<ProjectBean> getProject();

    //ITEM数据
    @GET("project/list/{pageIndex}/json?cid=294")
    Observable<PageItemBean> getProjectItem(@Path("pageIndex")int pageIndex, @Query("cid")int cid);

    /**
     * 注册接口
     */
    @POST("user/register")
    @FormUrlEncoded
    Observable<LoginBean> register(@Field("password")String password,
                                   @Field("repassword")String repassword,
                                   @Field("username")String username);

    /**
     * 注册接口
     */
    @POST("user/register")
    @FormUrlEncoded
    Observable<LoginBean> register2(@FieldMap Map<String,String> map);


    //登录
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("user/login")
    Observable<LoginBean> login(@Body RequestBody route);

}
