package com.jihwan.section02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteSessionDataServlet  extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // session은 서버에 저장되는 데이터이다.
        // 요청한 사용자의 session 데이터를 확인하기 위한 로직
        HttpSession session = req.getSession();
        Enumeration<String> sesstionNames = session.getAttributeNames();
        while (sesstionNames.hasMoreElements()) {
            System.out.println(sesstionNames.nextElement());
        }

        //시간만료
        //session.setMaxInactiveInterval(0);

        /*필기*/

        // 속성을 삭제
        session.removeAttribute("firstName");
        sesstionNames = session.getAttributeNames();
        while (sesstionNames.hasMoreElements()) {
            System.out.println(sesstionNames.nextElement());
        }

        // 세션자체를 무효화 하는 것으로 아래의 코드에서 에라가 발생된다.
        session.invalidate();
        sesstionNames = session.getAttributeNames();
        while (sesstionNames.hasMoreElements()) {
            System.out.println(sesstionNames.nextElement());
        }


    }
}
