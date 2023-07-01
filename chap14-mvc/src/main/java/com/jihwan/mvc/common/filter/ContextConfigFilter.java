package com.jihwan.mvc.common.filter;

import com.jihwan.mvc.common.config.ConfigLocation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class ContextConfigFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //데이터 접속 설정 정보 파일의 경로가 비어 있는 경우 초기회
        if(ConfigLocation.CONNECTION_CONFIG_LOCATION==null){
            String root = request.getServletContext().getRealPath("/");
            String connectionInfoPath = request.getServletContext().getInitParameter("connection-info");

            System.out.println("DB 접속 경로 설정 완료");
            ConfigLocation.CONNECTION_CONFIG_LOCATION= root+"/"+connectionInfoPath;

            System.out.println(  ConfigLocation.CONNECTION_CONFIG_LOCATION);

//            ConfigLocation.MAPPER_LOCATION="C:\\DEVTOOL\\apache-tomcat-9.0.76\\webapps\\ROOT\\//WEB-INF//mapper"+"/";
        }
        if (ConfigLocation.MAPPER_LOCATION == null) {
            String root = request.getServletContext().getRealPath("/");
            String mapperLocation = request.getServletContext().getInitParameter("mapper-location");
            System.out.println("매퍼 경로 설정 완료");
            ConfigLocation.MAPPER_LOCATION = root+"/"+mapperLocation;
        }

        chain.doFilter(request, response);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }


}
