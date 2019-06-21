package com.example.r2dbcrsocketplayground;

import io.rsocket.Closeable;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.server.TcpServerTransport;
import reactor.core.publisher.Mono;

public class MockServer {

    private Closeable server;

    private static final int TEST_PORT = 8888;

    public MockServer() {
        this.server = RSocketFactory.receive()
                .acceptor((setupPayload, reactiveSocket) -> Mono.just(new RsocketController()))
                .transport(TcpServerTransport.create("localhost", TEST_PORT))
                .start()
                .doOnNext(x -> System.out.println("************* Server started ********* " + "Port: " + 8888))
                .onTerminateDetach()
                .block();
    }


    public void dispose() {
        this.server.dispose();
    }

}
