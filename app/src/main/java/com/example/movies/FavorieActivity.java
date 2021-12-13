package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movies.API.Client;
import com.example.movies.API.Service;
import com.example.movies.Adapter.MoviesAdapter;
import com.example.movies.model.Movie;
import com.example.movies.model.MoviesResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavorieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorie);
        Intent intent=getIntent();
        ArrayList<Movie> list;
        RecyclerView rvmovies = (RecyclerView) findViewById(R.id.rvFavoritemovies);
        list = (ArrayList<Movie>) intent.getSerializableExtra("liste");
        MoviesAdapter adapter = new MoviesAdapter(list);
        rvmovies.setAdapter(adapter);
        // On déclare quelle type de LayoutManager on désire
        rvmovies.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }
}