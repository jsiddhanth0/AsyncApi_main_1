package com.example.demo12.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class servimpl implements serv {

//	@Async("AsyncTaskExecutor")
//	@Override
//	public CompletableFuture<String> Hello(String query) {
//		return CompletableFuture.supplyAsync(() ->{
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("I take 5 seconds to complete on a Thread named : " + Thread.currentThread().getName());
//			return "hello world and your query is: "+query  ;
//			});
//	}

    @Async("AsyncTaskExecutor") 
    public CompletableFuture<String> Hello(String query) {
        try {
            Thread.sleep(3500); 
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        System.out.println("I take 5 seconds to complete on a Thread named: " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture("hello world and your query is: " + query);
    }
}


