package com.example.demo12.configuration;
//package com.journaldev.log;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class asyncConfig implements AsyncConfigurer {
	
	@Bean("AsyncTaskExecutor")
	public Executor asyncTaskExecutor()
	{
		ThreadPoolTaskExecutor taskexecutor = new ThreadPoolTaskExecutor();	
		taskexecutor.setCorePoolSize(8);
//		taskexecutor.setMaxPoolSize(40);
		taskexecutor.setQueueCapacity(25);
		taskexecutor.setThreadNamePrefix("CaaS-");
//		// Set the RejectedExecutionHandler to log an error message
//        taskexecutor.setRejectedExecutionHandler((Runnable r, ThreadPoolExecutor e) -> {
//            
//           System.out.println("Task Rejected: Thread pool is full. Increase the thread pool size.");
//        });
		taskexecutor.initialize();
		return taskexecutor;
		
		
	}

}
