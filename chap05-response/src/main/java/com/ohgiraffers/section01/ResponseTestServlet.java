package com.ohgiraffers.section01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 서블릿의 역할
        * 1. 클라이언트의 요청을 받는다. - http method get/post 요청에 따라 parameter로 전달 받은 데이터를 꺼내올 수 있다.
        * (chap04-parameter)
        * 2. 비즈니스 로직 처리 = DB 접속과 CRUD에 대한 로직 처리 -> 서비스를 호풀하는 쪽으로 해결한다(MVC)
        * 3. 응답하기 -> 문자열로 동적인 웹(html)페이지를 만들고 스트림을 이용해 내보낸다
        * http 통신은 기본 text데이터를 전송 -> 브라우저 해석 -> 돔트리를 생성함*/

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("<title> 소임바보 </title>\n")
                .append("<body>\n")
                .append("<h1>작성자 : 고민영 </h1>\n")
                .append("</body>")
                .append("</html");

        /*
        * 클라이언트에게 내보낼 데이터의 타입을 응갑 헤더에 설정해준다.
        * content-type 헤더의 설정을 해주며ㅑ 설정하지 않으면 text/plain으로 설정된다.
        * */
        System.out.println("default reponse type : "+ resp.getContentType());
        /*기본 값은 text/plain이나 html 태그를 사용하면 요청시 text/html도 응압을 수락 가능하도록 헤더 설정이 되어 있다.
        * 그래서 자동으로 text/html 로 인식한다 하지만 text/plain으로 설정 하게 되면 html 태그를 태그로 인식하지 않고 문자열로 인식*/

        resp.setContentType("text/html");

        resp.setCharacterEncoding("UTF-8");
        System.out.println("changed response encoding : "+resp.getCharacterEncoding());

        PrintWriter out = resp.getWriter();

        //스티림으로 데이터를 내보낸다.
        out.print(responseBuilder.toString());

        out.flush();
        out.close();


    }
}
