package com.ohgiraffers.querystring;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name"); // /querystring?name=값
        System.out.println("name Parameter: " + name);

        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("나이 : " + age);

        String gender = req.getParameter("gender");

        System.out.println("성별 : " + gender);

        String national = req.getParameter("national");
        System.out.println("국적 : " + national);

        System.out.println("취미 : ");
        String[] hobbies = req.getParameterValues("hobbies");

        for (String hobbiy : hobbies) {
            System.out.println(hobbiy);
        }



    }
}