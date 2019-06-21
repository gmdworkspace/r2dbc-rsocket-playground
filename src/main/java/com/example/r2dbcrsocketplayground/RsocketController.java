package com.example.r2dbcrsocketplayground;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.rsocket.AbstractRSocket;
import io.rsocket.Payload;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Flux;

import java.util.Map;

public class RsocketController extends AbstractRSocket {

    private MoviesService moviesService;

    public RsocketController() {
        this.moviesService = new MoviesService();
    }

    public Flux<Payload> requestStream(Payload payload) {
        ObjectMapper mapper = new ObjectMapper();
        Flux<Map<String, Object>> movies = moviesService.getAllMoviesWithDetails();
        return Flux.create(s -> movies.subscribe(movie -> {
            try {
                s.next(DefaultPayload.create(mapper.writeValueAsString(movie)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, err -> System.out.println("error: " + err)));
    }
}