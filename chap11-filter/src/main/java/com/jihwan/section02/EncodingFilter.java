package com.jihwan.section02;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encodingType;

    public EncodingFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingType = filterConfig.getInitParameter("encoding-type");
        System.out.println(encodingType);
        System.out.println("encoding 초기화");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) request;
        if ("post".equals(hrequest.getMethod())) {
            request.setCharacterEncoding(encodingType);
            System.out.println("변경된 인코딩 타입 : " + request.getCharacterEncoding());

        }
        //꼭 작성
        chain.doFilter(request,response);
    }
}
