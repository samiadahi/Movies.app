package com.example.movies;

import com.bumptech.glide.Glide;
import com.example.movies.API.Client;
import com.example.movies.API.Service;
import com.example.movies.model.*;
import com.example.movies.Adapter.*;
import com.example.movies.model.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesActivity extends AppCompatActivity {
    //public ArrayList<Movie> movies =new ArrayList<>();
    public  List<Movie> movies;
    BottomNavigationView bottm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottm = findViewById(R.id.bot_nav);
        bottm.setSelectedItemId(R.id.popular);
        bottm.setOnNavigationItemReselectedListener(navlistener);
        Client client = new Client();
        Service apiService = client.getClient().create(Service.class);

        Call<MoviesResponse> call = apiService.getPopulardMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                movies = response.body().getResults();
                RecyclerView rvmovies = (RecyclerView) findViewById(R.id.rvmovies);
                MoviesAdapter adapter = new MoviesAdapter(movies);
                rvmovies.setAdapter(adapter);
                // On déclare quelle type de LayoutManager on désire
                rvmovies.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                ///rvmovies.addItemDecoration(new DividerItemDecoration(rvmovies.getContext(), DividerItemDecoration.HORIZONTAL));
            }


            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.d("erreur", t.getMessage());
            }
        });


    }
      private void loadJson() {
            // try {

        }

        private void loadTopRatedMovies() {
            // try {
            Client client = new Client();
            Service apiService = client.getClient().create(Service.class);

            Call<MoviesResponse> call = apiService.getTopRatedMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN);
            call.enqueue(new Callback<MoviesResponse>() {
                @Override
                public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                   movies = response.body().getResults();
                }
                @Override
                public void onFailure(Call<MoviesResponse> call, Throwable t) {
                    Log.d("erreur", t.getMessage());
                }
            });
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar,menu);
        MenuItem menuItem=menu.findItem(R.id.search_bar);
        SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setQueryHint("type here to search");
        ArrayList<Movie> searchMovies =new ArrayList<>();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchMovies.removeAll(searchMovies);
                for (int i=0;i<movies.size();i++){
                    if(movies.get(i).getTitle().equals(s))
                    {
                        searchMovies.add(movies.get(i));

                    }
                }
                Intent intent=new Intent(getApplicationContext(),Searchctivity.class);
                intent.putExtra("liste",(Serializable)searchMovies);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    //}

        //movies.add(new Movie("nom","desc","https://voi.img.pmdstatic.net/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2Fprismamedia_people.2F2018.2F10.2F29.2F9b8be122-64ba-40a2-826d-de20d8c4c7c4.2Ejpeg/2048x1536/quality/80/pierre-jean-chalencon.jpeg"));

        // on notifie au recycleview notre adapter




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

  //  public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s){
    //   checkSortOrder();
    //}
/*
    private void checkSortOrder() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String sortOrder=preferences.getString(
                this.getString(R.string.pref_sort_order_key),
                this.getString(R.string.pref_most_popular)
        );
        if(sortOrder.equals(this.getString(R.string.pref_most_popular))){
            loadJson();
        }
        else {
            loadJson1();
        }
    }
    */


}




