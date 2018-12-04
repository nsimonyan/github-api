package com.nsimonyan.wf.github.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.nsimonyan.wf.github" })
public class GithubApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(GithubApiApplication.class, args);
	}

}