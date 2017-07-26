package com.gonghui.maven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.gonghui.retrofit.RetrofitFactory;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);

        ApiServers build = RetrofitFactory.build(this, "https://api.github.com/", ApiServers.class);
        Call<User> users = build.getUsers();
        users.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.i("qwe", "response:" + response.body().toString());
                textView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
//        build.widgetList().enqueue(new Callback<List<Widget>>() {
//            @Override
//            public void onResponse(Call<List<Widget>> call, Response<List<Widget>> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Widget>> call, Throwable t) {
//
//            }
//        });
    }
}
