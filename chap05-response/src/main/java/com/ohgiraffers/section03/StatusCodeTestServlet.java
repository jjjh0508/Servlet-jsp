package com.ohgiraffers.section03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/status")
public class StatusCodeTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendError(404,"없는 페이지 입니다. 경로를 다시 확인해주세요"); // 사용자가 잘못된 요청을 하는 경우
        resp.sendError(500,"서버에서 문제가 발생되었습니다. 서버는 여러분이 개발 하였으니 여러분 잘못입니다.");

    }
}
