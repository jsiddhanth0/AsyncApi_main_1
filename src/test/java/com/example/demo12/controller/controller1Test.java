package com.example.demo12.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo12.services.serv;
@WebMvcTest(controllers = controller1.class)
class controller1Test {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private serv serv1; // Inject mock service

    @Test
    public void testHelloEndpoint() throws Exception {

        String query = "test query";
        String expectedResponse = "hello world and your query is: test query";
//        when(serv1.Hello(anyString())).thenReturn(CompletableFuture.completedFuture(expectedResponse));
        
        when(serv1.Hello(query)).thenReturn(CompletableFuture.completedFuture(expectedResponse));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/hello")
                                                      .content(query)
                                                      .contentType("application/json")).andReturn();

        assertEquals(expectedResponse, result.getResponse().getContentAsString()); // Assert response
    }
}
//String query = "test query";
//String expectedResponse = "hello world and your query is: test query";
//
//when(serv.Hello(query)).thenReturn(CompletableFuture.completedFuture(expectedResponse));
//
//MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/hello")
//                                                  .content(query)
//                                                  .contentType("application/json"))
//                              .andReturn();
//
//assertEquals(expectedResponse, result.getResponse().getContentAsString());
//}
//}





