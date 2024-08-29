package com.gcp.demo.gcpdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.gcp.demo")
public class GcpdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcpdemoApplication.class, args);
	}

}
