package com.example.mynewsfeed.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ArticleList {

    @SerializedName("articles")
    private ArrayList<Article> articleList;

    public ArrayList<Article> getArticleArrayList() {
        return articleList;
    }

    public void setArticleArrayList(ArrayList<Article> articleArrayList) {
        this.articleList = articleArrayList;
    }
}
