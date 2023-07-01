package com.oghiraffes.section01;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInfomationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String userId = req.getParameter("userId");

        String password = req.getParameter("password");

//        userId="로그인 완료됨";
        System.out.println("userId : "+userId);
        System.out.println("password :"+password);


        req.setAttribute("userId",userId);
        // /print로 인가
        RequestDispatcher rd = req.getRequestDispatcher("print");
        rd.forward(req,resp);

    }
}
