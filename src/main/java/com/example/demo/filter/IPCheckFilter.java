package com.example.demo.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class IPCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        log.debug("filter begin");
        HttpServletRequest req = (HttpServletRequest) request;
        String ip = request.getRemoteAddr();
        // ip 차단
        if("163.152.216.244".equals(ip)) {
            ((HttpServletResponse) response).sendRedirect("http://www.naver.com");
        }
        log.debug("ip : " + ip);
        chain.doFilter(req, response);
        log.debug("filter end");
    }
}