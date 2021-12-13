package com.example.movies.Adapter;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movies.DetailActivity;
import com.example.movies.model.*;
import com.example.movies.R;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    public static List<Movie> mMovies;
    public static Context mcontext;


    public MoviesAdapter(List<Movie>movies){
        mMovies=movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        Context context= parent.getContext();
        mcontext=parent.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);
        View movieView = inflater.inflate(R.layout.item,parent, false);
        return new ViewHolder(movieView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie= mMovies.get(position);
        ImageView imageView = holder.imageView;
        TextView title=holder.title;
        TextView vote_average=holder.vote_average;
        Glide.with(holder.itemView)
                .load(movie.getPosterPath()).placeholder(R.drawable.ic_android_black_24dp).error(R.drawable.ic_android_black_24dp)
                .into(imageView);
        title.setText(movie.getTitle());
        vote_average.setText(movie.getVote_average());

    }

    @Override
    public int getItemCount() {

        return mMovies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        public ImageView imageView;
        public TextView title;
        public  TextView vote_average;


        public ViewHolder (View itemView){
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image_url);
            title=(TextView)itemView.findViewById(R.id.movie_name);
            vote_average=(TextView)itemView.findViewById(R.id.rating);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    Movie clickedItem=mMovies.get(position);
                    Intent intent=new Intent(mcontext,DetailActivity.class);
                    intent.putExtra("image",clickedItem.getPosterPath());
                    intent.putExtra("title",clickedItem.getTitle());
                    intent.putExtra("date",clickedItem.getRelease_date());
                    intent.putExtra("langage",clickedItem.getOriginal_language());
                    mcontext.startActivity(intent);

                }
            });
        }
    }

}
