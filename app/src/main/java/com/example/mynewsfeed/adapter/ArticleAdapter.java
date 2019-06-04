package com.example.mynewsfeed.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mynewsfeed.R;
import com.example.mynewsfeed.activity.NewsActivity;
import com.example.mynewsfeed.model.Article;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {


    private ArrayList<Article> dataList;
    private Context mContext;

    public ArticleAdapter(ArrayList<Article> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, viewGroup, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticleViewHolder articleViewHolder, final int i) {

        articleViewHolder.text.setText(dataList.get(i).getTitle());
        articleViewHolder.description.setText(dataList.get(i).getDescription());
        articleViewHolder.url.setText(dataList.get(i).getUrl());

        articleViewHolder.url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, NewsActivity.class);
                //intent.putExtra("news", Intent.parseUri(articleViewHolder.));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {

        private TextView text, description, url;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text_title);
            description = itemView.findViewById(R.id.text_description);
            url = itemView.findViewById(R.id.text_url);

        }
    }
}
