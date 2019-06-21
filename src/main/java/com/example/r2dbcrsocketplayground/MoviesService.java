package com.example.r2dbcrsocketplayground;

import com.example.r2dbcrsocketplayground.config.R2dbcConnection;
import reactor.core.publisher.Flux;

import java.util.Map;

public class MoviesService {

    public Flux<Map<String, Object>> getAllMoviesWithDetails() {
        String query = "SELECT * FROM movies_metadata";
        return R2dbcConnection.getDatabaseClient().execute().sql(query).fetch().all();
    }
}
