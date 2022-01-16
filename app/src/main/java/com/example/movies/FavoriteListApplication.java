package com.example.movies;

import android.app.Application;

import com.example.movies.model.Movie;

import java.util.ArrayList;

public class FavoriteListApplication extends Application {
    private ArrayList<Movie> list;
    private String langue;
  public  void addMovie(Movie movie)
    {
        list.add(movie);
    }

    public void setList(ArrayList<Movie> list) {
        this.list = list;
    }
    public ArrayList<Movie> getList() {
        return  this.list;
    }
    public FavoriteListApplication(){
      this.list=new ArrayList<>();
    }


    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }
}
