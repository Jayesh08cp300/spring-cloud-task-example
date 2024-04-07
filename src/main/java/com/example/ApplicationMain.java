package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

@SpringBootApplication
@EnableTask
@Slf4j
public class ApplicationMain implements ApplicationRunner, TaskExecutionListener {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("This is SpringCloudTaskExample");
	}

	@Override
	public void onTaskStartup(TaskExecution taskExecution) {
		log.info("onTaskStartup() -> id = " + taskExecution.getExecutionId() + ", name = " + taskExecution.getTaskName());
	}

	@Override
	public void onTaskEnd(TaskExecution taskExecution) {
		log.info("onTaskEnd() -> id = " + taskExecution.getExecutionId() + ", name = " + taskExecution.getTaskName());
	}

	@Override
	public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
		log.info("onTaskFailed() -> id = " + taskExecution.getExecutionId() + ", name = " + taskExecution.getTaskName());
	}
}
