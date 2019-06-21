package com.example.r2dbcrsocketplayground;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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

		//Making it blockable for testing
		Iterable<String> result = client.getDataStream().toIterable();

		for(String movie: result) {
			System.out.println("Result:" + movie);

		}

		//Exit
		System.exit(0);
	}

}
