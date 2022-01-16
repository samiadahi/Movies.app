package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.example.movies.model.Genre;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity  {
    Context context;
    Resources resources;
    Button english,frensh;
    ArrayList<Genre> listeG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_page);
        english=(Button)findViewById(R.id.btn_en);
        frensh=(Button)findViewById(R.id.btn_fr);
        FavoriteListApplication app = (FavoriteListApplication) getApplicationContext();
        Intent intent=new Intent(getApplicationContext(),MoviesActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Locale locale=new Locale("en");
                Locale.setDefault(locale);
                Configuration configuration=new Configuration();
                configuration.locale=locale;
                app.setLangue("en");
                getApplicationContext().getResources().updateConfiguration(configuration,getApplicationContext().getResources().getDisplayMetrics());
                */
                 Resources resources=getResources();
                DisplayMetrics dm=resources.getDisplayMetrics();
                Configuration conf=resources.getConfiguration();
                String localCode="en";
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN){
                    conf.setLocale(new Locale(localCode.toLowerCase()));
                }
                else{
                    conf.locale=new Locale(localCode.toLowerCase());
                }

                resources.updateConfiguration(conf,dm);
                getApplicationContext().startActivity(intent);
            }
        });
        frensh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Locale locale=new Locale("fr");
                Locale.setDefault(locale);
                Configuration configuration=new Configuration();
                configuration.locale=locale;
                app.setLangue("fr");
                getApplicationContext().getResources().updateConfiguration(configuration,getApplicationContext().getResources().getDisplayMetrics());
                getApplicationContext().startActivity(intent);
            }

        });


    }


}