package com.online.trading;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.online.trading.filter.ErrorFilter;
import com.online.trading.filter.PostFilter;
import com.online.trading.filter.PreFilter;
import com.online.trading.filter.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class NetflixZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulServiceApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}
