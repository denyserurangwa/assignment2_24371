package com.auca.submission;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Authentication
 */
@WebFilter("/Authentication")
public class Authentication implements Filter {

    /**
     * Default constructor. 
     */
    public Authentication() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		HttpServletRequest httpRequest= (HttpServletRequest)request;
		HttpServletResponse httpResponse =(HttpServletResponse)response;
		chain.doFilter(request, response);
		
		HttpSession session=httpRequest.getSession(false);
		
		boolean loggedIn = (session != null) && (session.getAttribute("user")!= null);
		String loginURI = httpRequest.getContextPath() + "/index.html";
		boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
		if (loggedIn || loginRequest) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(loginURI);
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
