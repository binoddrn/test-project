package com.learn.ormsqlite.binod.projectforyoung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail extends AppCompatActivity {
    private List<JsonResponse> responses;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        id=getIntent().getStringExtra("id");
//        int inn=Integer.valueOf(id);

        if (NetworkUtils.isNetworkAvailable(Detail.this))
            getDetails();
        else
            NetworkUtils.showNoConnectionDialog(Detail.this);
    }
    private void getDetails(){
        Call<List<JsonResponse>> call;
        RetrofitAPI superAVApi = RetrofitService.createService();
        call=superAVApi.getDetails(id);
        call.enqueue(new Callback<List<JsonResponse>>() {
            @Override
            public void onResponse(Call<List<JsonResponse>> call, Response<List<JsonResponse>> response) {
                responses=response.body();
               // Log.e("github response", new Gson().toJson(j).toString());
               // Log.e("github response", new Gson().toJson(githubResponse).toString());
                Log.e("github response", new Gson().toJson(responses).toString());
           //     Log.e("github name", );
                //Log.e("github image", githubResponse.getAvatarUrl());
            }

            //@Override;
            public void onFailure(Call<List<JsonResponse>> call, Throwable t) {

            }
        });
    }
}
