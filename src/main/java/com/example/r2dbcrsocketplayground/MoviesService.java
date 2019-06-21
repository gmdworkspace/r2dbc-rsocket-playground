package com.example.r2dbcrsocketplayground;

import com.example.r2dbcrsocketplayground.config.R2dbcConnection;
import com.example.r2dbcrsocketplayground.model.Movie;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import reactor.core.publisher.Flux;

public class MoviesService {

    public Flux<Movie> getAllMoviesWithDetailsBySpringDataR2dbc() {
        String query = "select * from movies_metadata";
        return R2dbcConnection.getDatabaseClient().execute().sql(query).as(Movie.class).fetch().all();
    }

    //Not using spring-data-r2dbc here
    public Flux<Movie> getAllMoviesWithDetailsByR2dbcDriver() {
        String query = "select * from movies_metadata where MOVIE_ID like '862'";
        return R2dbcConnection.getConnection().flatMapMany(connection -> connection
                .createStatement(query)
                .execute()
                .flatMap(result -> result.map(MoviesService::toMovie)));
    }

    public static Movie toMovie(Row row, RowMetadata rowMetadata) {
        return new Movie(
                row.get("BUDGET", String.class),
                row.get("MOVIE_ID", String.class),
                row.get("IMDB_ID", String.class),
                row.get("LANG", String.class),
                row.get("TITLE", String.class),
                row.get("OVERVIEW", String.class),
                row.get("POSTER", String.class),
                row.get("RELEASE_DATE", String.class),
                row.get("REVENUE", String.class),
                row.get("RUNTIME", String.class),
                row.get("STATUS", String.class),
                row.get("VOTE_AVG", String.class),
                row.get("VOTE_COUNT", String.class)
        );

    }
}
