package com.oghiraffes.section02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/redirect")
public class RedirctServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("이 서블릿으로 redirect 성공");

        StringBuilder redirectText = new StringBuilder();
        redirectText.append("<!DOCTYPE html>\n")
                .append("<head>\n")
                .append(" <title>redirect</title>\n")
                .append("</head>\n")
                .append("<body>")
                .append("<h1>이 서블릿으로 사용자 요청 처리함 </h1>")
                .append("</body>\n")
                .append("</html>\n");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(redirectText.toString());
        out.flush();
        out.close();
        //설명 작성
        /*
        * redirect 하면 url이 재작성되어 새로고침 할 때 redirect 된 페이지에 대한 요청을 반복한다.
        * 즉, 이전 요청에 포함된 정보는 남아 잇지 않고  url이 변경되는 것이다. redirect의 특징이다.
        * http 요청은 요청 시 잠시 connection 을 맺고 응답 시에도 잠시 connection 을 맺으며
        * 요청 단위당 reqeust 객체는 한 개만 생성된다.
        * 따라서 첫 요청 시의 request와 현재 redirect 된 페이지의 request는 서로 다른 객체이므로
        * redirect를 쓰면 이전 서블릿의 값을 공유 해서 사용할 수 없는 것이다.
        *
        *
        *
        * */



    }
}
