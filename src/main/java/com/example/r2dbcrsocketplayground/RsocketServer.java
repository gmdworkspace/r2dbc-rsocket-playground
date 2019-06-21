package com.example.r2dbcrsocketplayground;

import io.rsocket.Closeable;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.server.WebsocketRouteTransport;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;
import reactor.netty.http.server.HttpServerRoutes;

import java.io.File;
import java.nio.file.Path;
import java.util.function.Consumer;

import static com.example.r2dbcrsocketplayground.config.Constants.rsockerPort;

public class RsocketServer {

    private Closeable server;

    private static Path webPath(String pathname) {
        return new File(pathname).getAbsoluteFile().toPath();
    }

    public RsocketServer() {

        HttpServer httpServer = HttpServer.create().port(rsockerPort);
        Consumer<HttpServerRoutes> routeSetup =
                routes -> {
                    routes.file("/", webPath("src/main/resources/web/pubic/index.html"));
                    routes.directory("/public", webPath("src/main/resources/web/public"));
                };

        this.server = RSocketFactory.receive()
                .acceptor((setupPayload, reactiveSocket) -> Mono.just(new RsocketController()))
                .transport(new WebsocketRouteTransport(httpServer, routeSetup, "/ws"))
                .start()
                .doOnNext(x -> System.out.println("************* Server started ********* " + "Port: " + rsockerPort))
                .onTerminateDetach()
                .block();

        this.server.onClose().block();
    }


    public void dispose() {
        this.server.dispose();
    }
}
