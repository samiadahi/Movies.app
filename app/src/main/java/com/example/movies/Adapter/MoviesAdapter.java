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
    public static ArrayList<Genre> listeG;


    public MoviesAdapter(List<Movie>movies,ArrayList<Genre> listeGe){
        mMovies=movies;
        listeG=listeGe;
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
        TextView original_language= holder.original_language;
        TextView overview= holder.overview;
        TextView genres = holder.genres;
        TextView homepage = holder.homepage;
        Glide.with(holder.itemView)
                .load(movie.getPosterPath()).placeholder(R.drawable.ic_android_black_24dp).error(R.drawable.ic_android_black_24dp)
                .into(imageView);
        title.setText(movie.getTitle());
        vote_average.setText(movie.getVote_average());
        original_language.setText(movie.getOriginal_language());

    }

    @Override
    public int getItemCount() {

        return mMovies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        public ImageView imageView;
        public TextView title;
        public  TextView vote_average;
        public TextView original_language;
        public TextView overview;
        public TextView genres;
        public TextView homepage;
        public ArrayList<String> listeGenre=new ArrayList<String>();


        public ViewHolder (View itemView){
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image_url);
            title=(TextView)itemView.findViewById(R.id.movie_name);
            vote_average=(TextView)itemView.findViewById(R.id.rating);
            original_language= (TextView) itemView.findViewById(R.id.original_language);
            genres= (TextView) itemView.findViewById(R.id.genres);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    Movie clickedItem=mMovies.get(position);
                    for(int i=0; i<listeG.size(); i++){
                        for(int j=0; j<clickedItem.getGenre_ids().size(); j++){
                            if(clickedItem.getGenre_ids().get(j) == listeG.get(i).getId())
                                listeGenre.add(listeG.get(i).getName());
                        }
                    }
                    Intent intent=new Intent(mcontext,DetailActivity.class);
                    intent.putExtra("image",clickedItem.getPosterPath());
                    intent.putExtra("title",clickedItem.getTitle());
                    intent.putExtra("date",clickedItem.getRelease_date());
                    intent.putExtra("langage",clickedItem.getOriginal_language());
                    intent.putExtra("overview",clickedItem.getOverview());
                    intent.putExtra("homepage",clickedItem.getHomepage());
                    intent.putExtra("genre",listeGenre);
                    mcontext.startActivity(intent);

                }
            });
        }
    }

}
