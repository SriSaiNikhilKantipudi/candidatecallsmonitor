package com.candidate.candidatecalls.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringbootConfig {
	
	@Autowired
	private static Environment env;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	
	 @Bean
	    public static PropertySourcesPlaceholderConfigurer devPropertyPlaceholderConfigurer() throws IOException {
	        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
	        configurer.setEnvironment(env);
	        configurer.setIgnoreUnresolvablePlaceholders(true);

	        return configurer;
	    }

}
