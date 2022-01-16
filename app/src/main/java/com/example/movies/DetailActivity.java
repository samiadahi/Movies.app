package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movies.model.Movie;

import java.io.Serializable;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=this.getIntent();
        String image=intent.getStringExtra("image");
        String title=intent.getStringExtra("title");
        String date=intent.getStringExtra("date");
        String langage=intent.getStringExtra("langage");
        String overview = intent.getStringExtra("overview");
        String homepage=intent.getStringExtra("homepage");
        ImageView poster=(ImageView)findViewById(R.id.poster);
        Glide.with(this).load(image).into(poster);
        TextView title_text =(TextView) findViewById(R.id.title);
        TextView langage_text =(TextView) findViewById(R.id.langue);
        TextView date_text =(TextView) findViewById(R.id.date);
        TextView overview_text= (TextView) findViewById(R.id.overview);
        TextView homepage_text= (TextView) findViewById(R.id.homepage) ;
        TextView genre= (TextView) findViewById(R.id.genre) ;
        homepage_text.setText(homepage);
        title_text.setText(title);
        overview_text.setText(overview);
        langage_text.setText(langage);
        date_text.setText(date);
        ArrayList<String> listeG=new ArrayList<String>();
        String gr="";
        Button btn_favorite=(Button)findViewById(R.id.btn_favorite);
        listeG = (ArrayList<String>) getIntent().getSerializableExtra("genre");
        for(int i = 0; i<listeG.size();i++)
        {
            gr = gr +" - "+ listeG.get(i);

        }
        genre.setText(gr);
        btn_favorite.setText(getApplicationContext().getResources().getString(R.string.add_to_favorite));
        getApplicationContext().getResources().getString(R.string.app_name);
        btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie movie=new Movie(image, "", "", title,"","","", "", "") ;
                Intent intent_favorite=new Intent(getApplicationContext(),FavorieActivity.class);
                FavoriteListApplication app = (FavoriteListApplication) getApplicationContext();
                ArrayList<Movie> list=app.getList();
                app.addMovie(movie);
                intent_favorite.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent_favorite);


            }
        });


    }
}