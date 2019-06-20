package com.example.r2dbcrsocketplayground;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class R2dbcRsocketPlaygroundApplicationTests {

	private static RsocketServer server;

	@BeforeClass
	public static void setUpClass() {
		server = new RsocketServer();
	}

	@AfterClass
	public static void tearDownClass() {
		server.dispose();
	}

	@Test
	public void testHelloWorldStreamFromServer() {

		MockClient client = new MockClient();
		String recieved = client.getDataStream().blockFirst();
		Assert.assertEquals( "Wrong value received", recieved, "Hello World!");
	}

}
