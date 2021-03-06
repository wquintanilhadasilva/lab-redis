package com.lab.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;

@Configuration
public class RedisConfiguration {
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
//	    return new JedisConnectionFactory();
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
		config.setHostName("localhost");
		config.setPort(6379);
	    JedisConnectionFactory jedisConFactory = new JedisConnectionFactory(config);
	    return jedisConFactory;
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    return template;
	}

	/*
	 * @Bean public DelegatingSecurityContextAsyncTaskExecutor
	 * taskExecutor(ThreadPoolTaskExecutor delegate) { return new
	 * DelegatingSecurityContextAsyncTaskExecutor(delegate); }
	 * 
	 * public void SpringAsyncConfig() {
	 * SecurityContextHolder.setStrategyName(SecurityContextHolder.
	 * MODE_INHERITABLETHREADLOCAL); }
	 */

}
