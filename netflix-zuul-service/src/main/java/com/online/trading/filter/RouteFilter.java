package com.online.trading.filter;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import com.netflix.zuul.ZuulFilter;

public class RouteFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "route";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		System.out.println("Using Route Filter");

		return null;
	}

}