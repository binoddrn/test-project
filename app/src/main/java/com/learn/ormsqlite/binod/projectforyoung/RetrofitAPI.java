package com.learn.ormsqlite.binod.projectforyoung;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by binod on 8/26/2017.
 */
    public interface RetrofitAPI {

        @GET("posts/")
        Call <List<JsonResponse>>getDeveloperDetails();

    @GET("posts/{id}comments")
    Call<List<JsonResponse>> getDetails(@Path("id")  String id);
    }

