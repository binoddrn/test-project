package com.learn.ormsqlite.binod.projectforyoung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail extends AppCompatActivity {
    private List<Detailresponse> responses;
    RecyclerView reclyclerview;
    private DetailAdapter adapter;

    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reclyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        reclyclerview.setLayoutManager(layoutManager);
        reclyclerview.setHasFixedSize(true);

        id=getIntent().getStringExtra("id");
       // int inn=Integer.valueOf(id);

        if (NetworkUtils.isNetworkAvailable(Detail.this))
            getDetails();
        else
            NetworkUtils.showNoConnectionDialog(Detail.this);
    }
    private void getDetails(){
        Call<List<Detailresponse>> call;
        RetrofitAPI superAVApi = RetrofitService.createService();
        call=superAVApi.getDetails(id);
        call.enqueue(new Callback<List<Detailresponse>>() {
            @Override
            public void onResponse(Call<List<Detailresponse>> call, Response<List<Detailresponse>> response) {
                responses=response.body();
                adapter=new DetailAdapter(responses,Detail.this);
                reclyclerview.setAdapter(adapter);

               // Log.e("github response", new Gson().toJson(j).toString());
               // Log.e("github response", new Gson().toJson(githubResponse).toString());
                Log.e("github response", new Gson().toJson(responses).toString());

           //     Log.e("github name", );
                //Log.e("github image", githubResponse.getAvatarUrl());
            }

            //@Override;
            public void onFailure(Call<List<Detailresponse>> call, Throwable t) {

            }
        });
    }

   /* private void getDetails(){
        Call<Detailresponse> call;
        RetrofitAPI superAVApi = RetrofitService.createService();
        call=superAVApi.getDetails(id);
        call.enqueue(new Callback<Detailresponse>() {
            @Override
            public void onResponse(Call<Detailresponse> call, Response<Detailresponse> response) {
                 responses=response.body();
                Log.e("github response", new Gson().toJson(responses).toString());
                Log.e("github name", responses.getBody());
                //Log.e("github image", githubResponse.getAvatarUrl());
            }

            @Override
            public void onFailure(Call<Detailresponse> call, Throwable t) {

            }
        });

    }*/
}
