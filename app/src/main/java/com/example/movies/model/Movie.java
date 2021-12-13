package com.example.movies.model;

import com.google.gson.annotations.SerializedName;

public class Movie implements java.io.Serializable {
    @SerializedName("poster_path")
    private String posterPath;
    private String desc;
    private String imageUrl;
    private String title;
    private String vote_average;
    private String overview;
    private String release_date;
    private String original_language;
    public String getPosterPath() {
        return  "https://image.tmdb.org/t/p/w500" +posterPath;
    }

    public String getDesc() {
        return desc;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public String getTitle(){return  title;}

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVote_average() {
        return vote_average;
    }

    public Movie(String posterPath, String desc, String imageUrl, String title,String original_language,String release_date,String vote_average) {
        this.posterPath = posterPath;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.title=title;
        this.release_date=release_date;
        this.original_language=original_language;
        this.vote_average=vote_average;
    }
}
