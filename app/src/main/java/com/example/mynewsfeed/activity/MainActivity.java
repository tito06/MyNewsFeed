package com.example.mynewsfeed.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mynewsfeed.R;
import com.example.mynewsfeed.adapter.ArticleAdapter;
import com.example.mynewsfeed.model.Article;
import com.example.mynewsfeed.model.ArticleList;
import com.example.mynewsfeed.network.GetArticleDataService;
import com.example.mynewsfeed.network.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArticleAdapter articleAdapter;
    private RecyclerView recyclerView;

    private final static String API_KEY = "302b4483572c45b79429d76c46785f31";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating handle for dataServiceInstance
        GetArticleDataService service = RetrofitInstance.getRetrofitInstance().create(GetArticleDataService.class);


        //Call method with parameter to get article data

        Call<ArticleList> call = service.getArticleData("us", API_KEY);

        call.enqueue(new Callback<ArticleList>() {
            @Override
            public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                generateArticleList(response.body().getArticleArrayList());
            }

            @Override
            public void onFailure(Call<ArticleList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something is worng...please try later", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void generateArticleList(ArrayList<Article> articleDataList){
        recyclerView = findViewById(R.id.recyclerView);

        articleAdapter = new ArticleAdapter(articleDataList, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(articleAdapter);
    }
}
