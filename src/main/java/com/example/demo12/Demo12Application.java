package com.example.demo12;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAsync
public class Demo12Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo12Application.class, args);
	}

	
//	@Bean("AsyncTaskExecutor")
//	public Executor asyncTaskExecutor()
//	{
//		ThreadPoolTaskExecutor taskexecutor = new ThreadPoolTaskExecutor();	
//		taskexecutor.setCorePoolSize(10);
////		taskexecutor.setMaxPoolSize(40);
//		taskexecutor.setQueueCapacity(1);
//		taskexecutor.setThreadNamePrefix("AsyncTask-");
////		// Set the RejectedExecutionHandler to log an error message
////        taskexecutor.setRejectedExecutionHandler((Runnable r, ThreadPoolExecutor e) -> {
////            
////           System.out.println("Task Rejected: Thread pool is full. Increase the thread pool size.");
////        });
//		taskexecutor.initialize();
//		return taskexecutor;
//		
//		
//	}
}
