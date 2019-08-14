package javaAdvancedLesson10.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import javaAdvancedLesson10.domain.UserRole;
import javaAdvancedLesson10.shared.FilterService;

@WebFilter("/bucket.jsp")
public class BucketFilter implements Filter {

	private FilterService filterService = FilterService.getFilterService();

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		filterService.doFilterValidation(request, response, chain, Arrays.asList(UserRole.USER));
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}