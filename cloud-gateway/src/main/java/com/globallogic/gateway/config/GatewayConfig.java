package com.globallogic.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globallogic.gateway.filter.JwtAuthenticationFilter;

@Configuration
public class GatewayConfig {

	@Autowired
	private JwtAuthenticationFilter filter;
	
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route("user-service", r -> r.path("/api/v1/**").filters(f -> f.filter(filter)).uri("lb://user-service"))
				.route("admin-service", r -> r.path("/admin/**").filters(f -> f.filter(filter)).uri("lb://admin-service"))
				.route("fav-food-service", r -> r.path("/favfood/**").filters(f -> f.filter(filter)).uri("lb://fav-food-service"))
				.route("recommendation-service", r -> r.path("/recommendFood/**").filters(f -> f.filter(filter)).uri("lb://recommendation-service")).build();
	}

}
