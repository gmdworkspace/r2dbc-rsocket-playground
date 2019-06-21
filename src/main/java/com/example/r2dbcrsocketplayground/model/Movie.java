package com.example.r2dbcrsocketplayground.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("movies_metadata")
public class Movie {

    @Column("BUDGET")
    private String budget;

    @Column("MOVIE_ID")
    private String movieId;

    @Column("IMDB_ID")
    private String imdbId;

    @Column("LANG")
    private String lang;

    @Column("TITLE")
    private String title;

    @Column("OVERVIEW")
    private String overview;

    @Column("POSTER")
    private String poster;

    @Column("RELEASE_DATE")
    private String releaseDate;

    @Column("REVENUE")
    private String revenue;

    @Column("RUNTIME")
    private String runtime;

    @Column("STATUS")
    private String status;

    @Column("VOTE_AVG")
    private String voteAvg;

    @Column("VOTE_COUNT")
    private String voteCount;

    public Movie(
            String budget,
            String movieId,
            String imdbId,
            String lang,
            String title,
            String overview,
            String poster,
            String releaseDate,
            String revenue,
            String runtime,
            String status,
            String voteAvg,
            String voteCount) {

        this.budget = budget;
        this.movieId = movieId;
        this.imdbId = imdbId;
        this.lang = lang;
        this.title = title;
        this.overview = overview;
        this.poster = poster;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.status = status;
        this.voteAvg = voteAvg;
        this.voteCount = voteCount;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVoteAvg() {
        return voteAvg;
    }

    public void setVoteAvg(String voteAvg) {
        this.voteAvg = voteAvg;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }
}
