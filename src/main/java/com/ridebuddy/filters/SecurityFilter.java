package com.ridebuddy.filters;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class SecurityFilter implements Filter {

	private static final Logger logger = Logger.getLogger(SecurityFilter.class);
	public static final String AUTHORIZED_KEY = "authorized";
	private static String loginUrl;
	private static Set<String> openUrls;
	private String context;

	public void destroy() {
		logger.info("SecurityFilter destroy...");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		logger.info("Received sessionId: " + session.getId());
		
		// //ridebuddy/resources/bootstrap/js/bootstrap.js
		String url = ((HttpServletRequest) request).getRequestURI().toString();
		url = url.replaceAll("/{2,}", "/");
		logger.info("URL: " + url);
		
		// check if request is authorized, if not redirect to loginUrl
		Boolean authorizedValue = (Boolean) (session.getAttribute(AUTHORIZED_KEY));
        boolean authorized = authorizedValue != null && authorizedValue;
		if (authorized || url.startsWith(loginUrl) || isOpen(url)) {
			filterChain.doFilter(request, response);
		} else {
			logger.info("Redirecting to login page");
			((HttpServletResponse)response).sendRedirect(loginUrl);
		}
	}

	protected boolean isOpen(String url) {
		boolean isOpen = false;
		if (openUrls != null) {
			for (String openUrl : openUrls) {
				if (url.startsWith(openUrl)) {
					isOpen = true;
					break;
				}
			}
		}
		return isOpen;
	}

	public void init(FilterConfig config) throws ServletException {
		loginUrl = config.getInitParameter("loginUrl");
		openUrls = new HashSet<String>();
		String openUrlsText = config.getInitParameter("open");
		String[] tab = openUrlsText.split(",");
		context = config.getInitParameter("context");
		for (String openUrl : tab) {
			openUrls.add(context + openUrl);
		}
		loginUrl = context + loginUrl;
	}
}
