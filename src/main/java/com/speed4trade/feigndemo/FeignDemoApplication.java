package com.speed4trade.feigndemo;

import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FeignDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignDemoApplication.class, args);

		GitHub github = Feign.builder().decoder(new GsonDecoder()).target(GitHub.class, "https://api.github.com");

		// Fetch and print a list of the contributors to this library.
		List<Contributor> contributors = github.contributors("twbs", "bootstrap");
		for (Contributor contributor : contributors) {
			System.out.println(contributor.login + " (" + contributor.contributions + ")");
		}
	}
}
