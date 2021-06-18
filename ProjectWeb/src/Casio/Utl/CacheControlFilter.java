package Casio.Utl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CacheControlFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		  HttpServletResponse resp = (HttpServletResponse) response;
	        resp.setHeader("Expires", "Tue, 03 Jul 2001 06:00:00 GMT");
	        resp.setDateHeader("Last-Modified", new Date().getTime());
	        resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
	        resp.setHeader("Pragma", "no-cache");

	        chain.doFilter(request, response);
		
	}

}
