package com.example.movies.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie implements java.io.Serializable {
    @SerializedName("poster_path")
    private String posterPath;
    private String desc;
    private List<Integer> genre_ids;
    private String imageUrl;
    private String title;
    private String vote_average;
    private String genres;
    private String overview;
    private String release_date;
    private String original_language;
    private String homepage;
    public String getPosterPath() {
        return  "https://image.tmdb.org/t/p/w500" +posterPath;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getHomepage() {
        return homepage;
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

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public String getGenres() {
        return genres;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getRelease_date() {
        return release_date;
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

    public String getGenre() { return genres; }

    public void setGenre(String genre) { this.genres = genre; }

    public Movie(String posterPath, String desc, String imageUrl, String title, String original_language, String release_date, String vote_average, String genres, String homepage)  {
        this.posterPath = posterPath;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.title=title;
        this.release_date=release_date;
        this.original_language=original_language;
        this.vote_average=vote_average;
        this.genres=genres;
        this.homepage = homepage;
    }
}
