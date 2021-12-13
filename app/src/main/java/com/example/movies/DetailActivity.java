package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        ImageView poster=(ImageView)findViewById(R.id.poster);
        Glide.with(this).load(image).into(poster);
        TextView title_text =(TextView) findViewById(R.id.title);
        TextView langage_text =(TextView) findViewById(R.id.langue);
        TextView date_text =(TextView) findViewById(R.id.date);
        title_text.setText(title);
        langage_text.setText(langage);
        date_text.setText(date);
        Button btn_favorite=(Button)findViewById(R.id.btn_favorite);
        ArrayList<Movie> list=new ArrayList<>();
        btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie movie=new Movie(image, null, null, title,null,null,null);
                Intent intent_favorite=new Intent(getApplicationContext(),FavorieActivity.class);
                list.add(movie);
                intent_favorite.putExtra("liste",(Serializable)list);
                intent_favorite.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent_favorite);

            }
        });


    }
}