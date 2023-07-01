package com.jihwan.section02;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String pass = req.getParameter("password");
        String name = req.getParameter("name");
        System.out.println("userId : "+userId);
        System.out.println("pass : "+pass);
        System.out.println("name : "+name);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        passwordEncoder.encode(pass);
//        passwordEncoder.encode(pass);
        // ""에 입력된 평문과 암호화된 비밀번호랑 같은지 비교
        System.out.println("비밀번호 확인 pass01 : "+passwordEncoder.matches("pass01",pass));
        System.out.println("비밀번호 확인 pass02 : "+passwordEncoder.matches("pass02",pass));
        SimpleDateFormat sip = new SimpleDateFormat("MM dd HH mm");
        Date orderDate = new Date();
        String orderTime = sip.format(orderDate);
        System.out.println(orderTime);

    }
}
