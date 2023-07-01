package com.jihwan.section02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/*2-3. session Listenr*/
@WebServlet("/session")
public class SessionListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("발급 받은 session ID : "+session.getId());

        session.setAttribute("username","honggildong");
        session.setAttribute("age",20);
        session.setAttribute("gender","M");

        session.setAttribute("user",new UserDTO("honggildong",20));

        session.setAttribute("username","hong");
        session.removeAttribute("gender");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.print("<head>");
        out.print("<title> 접속자 확인 </title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1> 접속자 확인: "+SessionListenerTest.userCnt+ "</h1>");
        out.print("</body>");
        out.print("</html>");
//        session.invalidate();

    }
}
