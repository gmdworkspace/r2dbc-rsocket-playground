package com.example.r2dbcrsocketplayground;

import io.rsocket.Closeable;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.server.TcpServerTransport;
import reactor.core.publisher.Mono;

import java.io.File;
import java.nio.file.Path;

import static com.example.r2dbcrsocketplayground.config.Constants.rsockerPort;

public class RsocketServer {

    private Closeable server;

    private static Path webPath(String pathname) {
        return new File(pathname).getAbsoluteFile().toPath();
    }

    public RsocketServer() {

        this.server = RSocketFactory.receive()
                .acceptor((setupPayload, reactiveSocket) -> Mono.just(new RsocketController()))
                .transport(TcpServerTransport.create("localhost", rsockerPort))
                .start()
                .doOnNext(x -> System.out.println("************* Server started ********* " + "Port: " + rsockerPort))
                .block();
    }


    public void dispose() {
        this.server.dispose();
    }
}
