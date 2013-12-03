package com.bms.base.web.filter;


import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;



/**
 * 请求过滤器.
 *
 */
public class RequestProxyFilter implements Filter {
	/** 无需过滤的URI */
	private String 		excludingPattern;
	private Pattern[] 	eps;
	
	private long requestCount = 0;

	private synchronized String nextThreadId() {
		return "Request-" + ++requestCount;
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		
		System.getProperties().setProperty("proxySet", "true");
		System.getProperties().setProperty("http.proxyHost", "127.0.0.1");
		System.getProperties().setProperty("http.proxyPort", "8087");
		
		this.excludingPattern = config.getInitParameter("excludingPattern");
		
		if (!StringUtils.isEmpty(this.excludingPattern)) {
			String[] es = this.excludingPattern.split("[,;]");
			List<Pattern> ls = new ArrayList<Pattern>();
			for (String e : es) {
				ls.add(Pattern.compile(e.trim()));
			}
			eps = new Pattern[ls.size()];
			ls.toArray(eps);
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
	        throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String uri = request.getRequestURI();
		if (noCheckUrl(uri)) {
			chain.doFilter(req, resp);
			return;
		}
		if (uri.equals(request.getContextPath() + "/")) {
			chain.doFilter(req, resp);
			return;
		}
		
		Thread.currentThread().setName(nextThreadId());
		
		String httpUrl = "http://test2bms.appspot.com" + uri.substring(request.getContextPath().length());
		
		response.getOutputStream().write(this.getByteArray(httpUrl, "UTF-8"));
		return;
		
	}

	
	
	public byte[] getByteArray(String httpUrl, String Charset) {
		System.out.println(httpUrl);
		try {
			URL url = new URL(httpUrl.toString());
			try {
				URLConnection urlCon = (HttpURLConnection) url.openConnection();
				
				BufferedInputStream is = new BufferedInputStream(urlCon.getInputStream());
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				
				int len = 0;
				byte[] b = new byte[1024];
				while ((len = is.read(b)) != -1) {
				    baos.write(b, 0, len);
				}
				return baos.toByteArray();
			} catch (IOException e) {

			}
		} catch (MalformedURLException e) {
		}

		return new byte[0];
	}
	
	private boolean noCheckUrl(String url) {
		if (eps == null || eps.length == 0) {
			return false;
		}

		for (Pattern p : eps) {
			if (p.matcher(url).find()) {
				return true;
			}
		}

		return false;
	}
	
	@Override
	public void destroy() {
	}
}