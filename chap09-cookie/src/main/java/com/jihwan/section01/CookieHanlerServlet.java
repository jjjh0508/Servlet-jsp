package com.jihwan.section01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieHanlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // post는 인코딩 설정을 해야한다.
        req.setCharacterEncoding("UTF-8");

        //사용자의 요청 값을 꺼내온다
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        /*
        * 1. 쿠키를 생성한다. Cookie 변수명 = new Cookie("key");
        * 2. 생성한 쿠키의 만료시간을 설정한다. 변수명.setMaxAge(시간); 초 단위로 계산됨
        * 3. 응답 헤더에 쿠기를 담는다. resp.addCookie(값)
        * 4. 응답을 보낸다.
        *
        * 쿠키는 일부 제약사항이 있다.
        * 쿠키의 이름은 ascii 문자만을 사용해야 하며 한번 설정된 쿠키의 이름은 변경할 수 없다.
        * 또한 쿠키의 이름에는 공백문자와 일부 특수문자([] () = , "\ ? @ : ;)를 사용 할 수 없다.
        *
        *
        *
        *
        *  */

        //요청값을 쿠기에 담아준다. key , value
        Cookie firstCookie = new Cookie("firstName", firstName);
        Cookie lastCookie = new Cookie("lastName", lastName);

        //쿠기에 만료 시간을 설정한다 . 이후 쿠키는 삭제된다.
        firstCookie.setMaxAge(60*60*24);// 초 단위 하루
        lastCookie.setMaxAge(60*60*24);

        // 사용자 응답시 쿠키의 값을 담아서 보낸다.(저장)
        resp.addCookie(firstCookie);
        resp.addCookie(lastCookie);

        resp.sendRedirect("redirect");



    }
}
