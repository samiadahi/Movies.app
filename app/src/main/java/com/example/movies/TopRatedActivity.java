package com.example.movies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.movies.API.Client;
import com.example.movies.API.Service;
import com.example.movies.Adapter.MoviesAdapter;
import com.example.movies.model.Movie;
import com.example.movies.model.MoviesResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRatedActivity extends AppCompatActivity {
    BottomNavigationView bottm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_rated);
         bottm = findViewById(R.id.bot_nav_top_rated);
         bottm.setSelectedItemId(R.id.top);
        bottm.setOnNavigationItemReselectedListener(navlistener);
        Client client = new Client();
        Service apiService = client.getClient().create(Service.class);

        Call<MoviesResponse> call = apiService.getTopRatedMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> TopRatedmovies = response.body().getResults();
                TopRatedmovies = response.body().getResults();
                RecyclerView top_rated = (RecyclerView) findViewById(R.id.top_rated);
                MoviesAdapter adapter = new MoviesAdapter(TopRatedmovies);
                top_rated.setAdapter(adapter);
                // On déclare quelle type de LayoutManager on désire
                top_rated.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }
            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.d("erreur", t.getMessage());
            }
        });
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