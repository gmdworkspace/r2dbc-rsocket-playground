package com.example.r2dbcrsocketplayground;

import io.rsocket.AbstractRSocket;
import io.rsocket.Payload;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Flux;

public class RsocketController extends AbstractRSocket {

    public Flux<Payload> requestStream(Payload payload) {
        return Flux.create(s -> s.next(DefaultPayload.create("Hello World!")));
    }
}