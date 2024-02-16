package com.example.demo12.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class servimplTest {
	public serv serv1;

	@Test
	public void testHelloWithValidQuery() {
	    String query = "test query";
	    String expectedResponse = "hello world and your query is: test query";

	    String actualResponse = null;
		try {
			actualResponse = serv1.Hello(query).join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    assertEquals(expectedResponse, actualResponse);
	}
}
