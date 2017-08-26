package com.learn.ormsqlite.binod.projectforyoung;



import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by binod on 8/26/2017.
 */

public class RetrofitService {
    private  static String APPLICATION_BASE_URL = "https://jsonplaceholder.typicode.com/";

    public RetrofitService() {
    }

    public static RetrofitAPI createService() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(APPLICATION_BASE_URL)
                .client(okHttpClient)
                .build()
                .create(RetrofitAPI.class);
    }
}
