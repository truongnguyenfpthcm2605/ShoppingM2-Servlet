package com.m2m.shopping.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterUTF8 implements HttpFilter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpFilter.super.doFilter(req, res, chain);
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		chain.doFilter(req, res);
	}
}
