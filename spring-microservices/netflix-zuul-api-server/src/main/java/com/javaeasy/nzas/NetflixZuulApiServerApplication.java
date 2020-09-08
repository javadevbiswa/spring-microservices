package com.javaeasy.nzas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class NetflixZuulApiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiServerApplication.class, args);
	}
	
	//This bean is for spring cloud sleuth
	@Bean
	public Sampler defaultSampler() {
		return Sampler.NEVER_SAMPLE;
	}

}
