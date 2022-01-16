package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.movies.Adapter.MoviesAdapter;
import com.example.movies.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class Searchctivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchctivity);
        System.out.println("hh");
        RecyclerView rvmovies = (RecyclerView) findViewById(R.id.rvsearchvmovies);
        ArrayList<Movie> list;
        Intent intent=getIntent();
        list = (ArrayList<Movie>) intent.getSerializableExtra("liste");
        System.out.println("resuuu"+list.size());
        if(list!=null)
        {
            if(list.size()!=0)
            {
                MoviesAdapter adapter = new MoviesAdapter(list,null);
                rvmovies.setAdapter(adapter);
                // On déclare quelle type de LayoutManager on désire
                rvmovies.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }
        }


    }
}