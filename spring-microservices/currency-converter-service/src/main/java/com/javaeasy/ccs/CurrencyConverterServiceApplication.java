package com.javaeasy.ccs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.javaeasy.ccs.ces.proxy")
@EnableEurekaClient
public class CurrencyConverterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterServiceApplication.class, args);
	}

	@Bean
	public Sampler defaultSample() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
