package com.example.r2dbcrsocketplayground;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Flux;

import static com.example.r2dbcrsocketplayground.config.Constants.rsockerPort;

public class MockClient {

    private final RSocket socket;

    public MockClient() {
        this.socket = RSocketFactory.connect()
                .transport(TcpClientTransport.create("localhost", rsockerPort))
                .start()
                .block();
    }

    public Flux<String> getDataStream() {
        return socket
                .requestStream(DefaultPayload.create("SOME_PAYLOAD"))
                .map(Payload::getDataUtf8)
                .onErrorReturn(null);
    }
    public void dispose() {
        this.socket.dispose();
    }
}