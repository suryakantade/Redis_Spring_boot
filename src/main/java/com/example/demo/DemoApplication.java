package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
@EnableJpaRepositories(basePackages =  "com.*")
@EntityScan("com.*")
@EnableAutoConfiguration
public class DemoApplication {

	@Value("${com.example.redis.host}")
	String redisHost;
	@Value("${com.example.redis.port}")
	int redisPort;

	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		JedisConnectionFactory jedisConnection = new JedisConnectionFactory();
		jedisConnection.setHostName(redisHost);
		jedisConnection.setPort(redisPort);
		return jedisConnection;
	}

	@Bean
	public RedisTemplate<String,Object> createTemplate(){
		RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return  redisTemplate;
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
