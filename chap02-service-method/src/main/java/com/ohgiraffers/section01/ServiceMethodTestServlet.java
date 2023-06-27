package com.ohgiraffers.section01;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {
    public ServiceMethodTestServlet() {
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)  req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;

        //Request는 요청을 의미하며 이는 요청한 쪽의 method를 확인해야한다.
        String httpMethod = httpServletRequest.getMethod();
        System.out.println("httpMethod : "+httpMethod);
        
        //사용자의 요청을 확인하여 보내주는 역할을 수행함
        if(("GET").equals(httpMethod)){
            //아래의 doGET 메서드와 매개변수의 타입을 일치시킨다.
            doGet(httpServletRequest , httpServletResponse);
        } else if (("POST").equals(httpMethod)) {
            //아래의 doPOST메서드와 매개변수의 타입을 일치시킨다.
            doPost(httpServletRequest, httpServletResponse);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*get 방식의 요청은 QueryStringParameter 이라는 방식으로 데이터를 전송하게 된다.
        * https://cafe.naver.com/{single2678}?poshNum=6756와 같이 요청을 전달하게 된다
        * 데이터가 노출되어 중요하지 않은 값  post 번호 혹은 일반적인 데이터를 주고 받는다.
        * 주소창의 크기만큼 데이터를 주고 받기 때문에 데이터의 범위가 크지 않아 파일을 주고 받을떄 사용하지 않는다.*/
        System.out.println("GET 요청을 처리할 메소드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*post 방식의 요청은 데이터가 body에 담겨져서 전송된다.
        * https://cafe.naver.com/{single2678} 요청된 url은 다음과 같다
        * 데이터가 노출되지 않아 보안성이 능가하며 http body에 데이터를 담아 오기 떄무ㅡㄴ에
        * 많은 양의 데이터를 전송하는 것이 가능하다.
        * */
        System.out.println("POST 요청을 처리할 메소드 호출");
    }


}