package com.learn.ormsqlite.binod.projectforyoung;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {
    TextView nam,emil;
    private List<JsonResponse> responses;
    private RecyclerAdapter adapter;

    RecyclerView reclyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nam=(TextView)findViewById(R.id.name);
        emil=(TextView)findViewById(R.id.email);

        reclyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        reclyclerview.setLayoutManager(layoutManager);
        reclyclerview.setHasFixedSize(true);



        if (NetworkUtils.isNetworkAvailable(MainActivity.this))
            getDeveloperDetails();
        else
            NetworkUtils.showNoConnectionDialog(MainActivity.this);
    }

    private void getDeveloperDetails(){
        Call <List<JsonResponse>> call;
      //  final ProgressDialog progress = ProgressDialog.show(MainActivity.this, "", "Loading", true, false);
        RetrofitAPI superAVApi = RetrofitService.createService();
        call = superAVApi.getDeveloperDetails();

        call.enqueue(new Callback<List<JsonResponse>>() {
            @Override
            public void onResponse(Call<List<JsonResponse>> call, Response<List<JsonResponse>> response) {
                responses=response.body();
                adapter=new RecyclerAdapter(MainActivity.this,responses);
                reclyclerview.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<JsonResponse>> call, Throwable t) {

            }
        });

    }
}

