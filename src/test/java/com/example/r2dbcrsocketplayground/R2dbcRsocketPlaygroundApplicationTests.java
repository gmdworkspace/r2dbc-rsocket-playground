package com.example.r2dbcrsocketplayground;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Duration;

public class R2dbcRsocketPlaygroundApplicationTests {

	private static MockServer server;

	@BeforeClass
	public static void setUpClass() {
		server = new MockServer();
	}

	@AfterClass
	public static void tearDownClass() {
		server.dispose();
	}

	@Test
	public void testHelloWorldStreamFromServer() {

		MockClient client = new MockClient();

		System.out.println("Result:" + client.getDataStream().blockLast(Duration.ofSeconds(30)));

	}

}
