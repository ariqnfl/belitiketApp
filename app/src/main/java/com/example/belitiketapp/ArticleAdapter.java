package com.example.belitiketapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    ArrayList<ArticleCard> myArticle;

    public ArticleAdapter(ArrayList<ArticleCard> myArticle) {
        this.myArticle = myArticle;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_myarticle,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bind(myArticle.get(i));
    }

    @Override
    public int getItemCount() {
        return myArticle == null ? 0 : myArticle.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView xphoto_article;
        private String nama_artikel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            xphoto_article = itemView.findViewById(R.id.article_display);
            itemView.setOnClickListener(this);
        }

        void bind(ArticleCard articleCard){
            Picasso.with(itemView.getContext()).load(articleCard.getUrl_photo_artikel()).centerCrop().fit().into(xphoto_article);
            nama_artikel = articleCard.getNama_artikel();
        }
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(itemView.getContext(),ArticleAct.class);
            intent.putExtra("nama_artikel",nama_artikel);
            itemView.getContext().startActivity(intent);
        }


        //    public ArticleAdapter(ArrayList<ArticleCard> p, Context c) {
//        context = c;
//        myArticle = p;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        return new ViewHolder(LayoutInflater.
//                from(context).inflate(R.layout.item_myarticle,
//                viewGroup, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        Picasso.with(context).load(myArticle.get(i).getUrl_photo_artikel()).centerCrop().fit().into(viewHolder.xphoto_article);
//        nama_artikel = myArticle.get(i).getNama_artikel();
//        viewHolder.itemView.setOnClickListener(this );
//    }
//
//    @Override
//    public int getItemCount() {
//        return myArticle.size();
//    }
//
//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(context,ArticleAct.class);
//        intent.putExtra("nama_artikel",nama_artikel);
//        context.startActivity(intent);
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView xphoto_article;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            xphoto_article = itemView.findViewById(R.id.article_display);
//        }

    }
}
