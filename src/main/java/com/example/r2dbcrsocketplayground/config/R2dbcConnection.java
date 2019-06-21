package com.example.r2dbcrsocketplayground.config;

import io.r2dbc.mssql.MssqlConnection;
import io.r2dbc.mssql.MssqlConnectionConfiguration;
import io.r2dbc.mssql.MssqlConnectionFactory;
import org.springframework.data.r2dbc.function.DatabaseClient;
import reactor.core.publisher.Mono;

import static com.example.r2dbcrsocketplayground.config.Constants.*;


public class R2dbcConnection {

    //Database client from spring-data-r2dbc
    public static DatabaseClient getDatabaseClient() {
        MssqlConnectionConfiguration configuration = MssqlConnectionConfiguration.builder()
                .host(mssqlHost)
                .username(mssqlUsername)
                .password(mssqlPassword)
                .database(mssqlDbName)
                .build();

        MssqlConnectionFactory factory = new MssqlConnectionFactory(configuration);

       return DatabaseClient.create(factory);
    }

    //Connection from R2DBC driver
    public static Mono<MssqlConnection> getConnection() {
        MssqlConnectionConfiguration configuration = MssqlConnectionConfiguration.builder()
                .host(mssqlHost)
                .username(mssqlUsername)
                .password(mssqlPassword)
                .database(mssqlDbName)
                .build();

        MssqlConnectionFactory factory = new MssqlConnectionFactory(configuration);

        return factory.create();
    }
}
