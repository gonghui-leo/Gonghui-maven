package com.gonghui.maven;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by tsj014 on 2017/7/25.
 */

public interface ApiServers {
    @Headers("Cache-Control:public ,max-age=60")
    @GET("users/list")
    Call<User> getUsers();

    @Headers("Cache-Control: max-age=640000")
    @GET("widget/list")
    Call<List<Widget>> widgetList();
}
