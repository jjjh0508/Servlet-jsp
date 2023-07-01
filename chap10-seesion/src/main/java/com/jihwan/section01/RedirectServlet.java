package com.jihwan.section01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("firstName : " + req.getParameter("firstName"));
        System.out.println("lastName : "+req.getParameter("lastName"));

        //세션의 정보를 확인하기 위한 로직(톰캣 서버 내부)
        HttpSession session = req.getSession();
        System.out.println("redirect 페이지 session id : "+session.getId());

        Enumeration<String> sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }





        // 사용자에게 응답을 해주기 위한 로직
        String firstName =(String) session.getAttribute("firstName");
        String lastName = (String) session.getAttribute("lastName");
        // 응갑의 대한 인코딩 설정
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();


        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3> your first name is");
        out.println(firstName);
        out.println("and list name");
        out.println(lastName);
        out.println("</h3>");
        out.println("</body>");
        out.println("</html>");


        out.flush();
        out.close();
    }
}
