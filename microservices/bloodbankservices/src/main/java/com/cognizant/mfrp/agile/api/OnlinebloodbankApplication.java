package com.cognizant.mfrp.agile.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;




@SpringBootApplication
@EnableDiscoveryClient
public class OnlinebloodbankApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(OnlinebloodbankApplication.class, args);
	
	}
}
