package com.example.movies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movies.API.Client;
import com.example.movies.API.Service;
import com.example.movies.Adapter.MoviesAdapter;
import com.example.movies.model.Genre;
import com.example.movies.model.GenreList;
import com.example.movies.model.Movie;
import com.example.movies.model.MoviesResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavorieActivity extends AppCompatActivity {
    BottomNavigationView bottm;
    ArrayList<Genre>listeG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorie);
        bottm=(BottomNavigationView)findViewById(R.id.bot_nav_favorite);
        bottm.setSelectedItemId(R.id.favoris);
        bottm.setOnNavigationItemReselectedListener(navlistener);
        FavoriteListApplication app = (FavoriteListApplication) getApplicationContext();
        ArrayList<Movie> list=app.getList();
        System.out.println("heey"+list.size());
        RecyclerView favoriteMovies = (RecyclerView) findViewById(R.id.rvFavoritemovies);
        MoviesAdapter adapter = new MoviesAdapter(list,null);
        favoriteMovies.getRecycledViewPool().clear();
        favoriteMovies .setAdapter(adapter);
        // On déclare quelle type de LayoutManager on désire
        favoriteMovies .setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }

    private BottomNavigationView.OnNavigationItemReselectedListener navlistener =
            new BottomNavigationView.OnNavigationItemReselectedListener() {
                @Override
                public void onNavigationItemReselected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.popular:
                            Intent intent=new Intent(getApplicationContext(),MoviesActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            getApplicationContext().startActivity(intent);
                            break;
                        case R.id.top:
                            Intent intent_top=new Intent(getApplicationContext(),TopRatedActivity.class);
                            intent_top.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            getApplicationContext().startActivity(intent_top);

                            break;
                        case R.id.upcoming:
                            Intent intent_upcoming=new Intent(getApplicationContext(),UpcomingActivity.class);
                            intent_upcoming.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            getApplicationContext().startActivity(intent_upcoming);

                            break;

                        case  R.id.favoris:
                            Intent intent_favoris=new Intent(getApplicationContext(),FavorieActivity.class);
                            intent_favoris.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            getApplicationContext().startActivity(intent_favoris);
                    }


                }
            };
}