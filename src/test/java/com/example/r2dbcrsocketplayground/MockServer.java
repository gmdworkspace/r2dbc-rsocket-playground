package com.example.r2dbcrsocketplayground;

import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.server.TcpServerTransport;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

public class MockServer {

    private Disposable server;

    private static final int TEST_PORT = 8888;

    public MockServer() {
        this.server = RSocketFactory.receive()
                .acceptor((setupPayload, reactiveSocket) -> Mono.just(new RsocketController()))
                .transport(TcpServerTransport.create("localhost", TEST_PORT))
                .start()
                .doOnNext(x -> System.out.println("************* Server started ********* " + "Port: " + 8888))
                .subscribe();
    }


    public void dispose() {
        this.server.dispose();
    }

}
