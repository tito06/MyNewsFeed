package com.example.mynewsfeed.network;

import com.example.mynewsfeed.model.ArticleList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetArticleDataService {

    @GET("top-headlines")
    Call<ArticleList> getArticleData(@Query("country") String country, @Query("apiKey") String API_KEY);
}
