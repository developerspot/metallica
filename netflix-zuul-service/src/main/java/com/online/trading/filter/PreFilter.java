package com.online.trading.filter;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PreFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PreFilter.class);

	@Override
	public String filterType() {
		return "pre";
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
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

		return null;
	}

}