package com.example.demo12.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

public interface serv {
	@Async("AsyncTaskExecutor")
	public default CompletableFuture<String> Hello(String query) {
		// TODO Auto-generated method stub
		return null;
	}
}
