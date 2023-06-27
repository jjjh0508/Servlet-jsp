package com.ohgiraffers.headers.scetion01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/headers")
public class ReqeustHeaderPrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> heaerNames = req.getHeaderNames();
        while (heaerNames.hasMoreElements()) {
            System.out.println(heaerNames.nextElement());

        }
        // accept 요청을 보낼 때 서버에게 요청할 응답 타입 명시
        System.out.println("accept: "+req.getHeader("accept"));
        //accept-encoding 응ㄱ답시 원하는 인코딩 방식
        System.out.println("accept-encoding" +req.getHeader("accept-encoding"));
        //accept-language : 응답시 원하는 언어
        System.out.println("accept-language : "+req.getHeader("accept-language"));
        //connection : http 통신이 완료된 후에 네트워크 접속을 유지할 것인지 결정(기본값 : keep-alive= 연결이 열린 상태유지)
        System.out.println("connection : "+req.getHeader("connection"));
        /// host: 서버의 도메인 네임과 서버가 현재 listening 중인 TCP 포트 지점(반드시 하나가 존재, 없거나 둘 이상이면 404)
        System.out.println("host : "+req.getHeader("host"));
        //referer 이 페이지 이전에 대한 주소
        System.out.println("referer: "+req.getHeader("referer"));

        //sec-fetch-dest 요청대상
        System.out.println("sec-fetch-dest : "+req.getHeader("sec-fetch-dest"));
        //sec-fetch-mode : 요청모드
        System.out.println("sec-fetch-mode :"+req.getHeader("sec-fetch-mode"));
        //sec-fetch-site : 출처(origin)와 요청된 resource 사이의 관계
        System.out.println("sec-fetch-site : "+req.getHeader("sec-fetch-site"));
        //sec-fetch-user 사용자가 시작한 요청일 때만 보내짐
        System.out.println("sec-fetch-user : "+req.getHeader("sec-fetch-user"));
        //cache-control캐시 설정
        System.out.println("cache-control : "+req.getHeader("cache-control"));
        //upgrade-insecure-requests Http 요청 헤더는 암호화 되고 인증된 응답에 대한 클라이언트의 기본 설정을 표현
        System.out.println("upgrade-insecure-requests : "+req.getHeader("upgrade-insecure-requests"));

        //user-agent: 현재 사용자가 어떤 클라이언트 (os, browser)를 이용해 보낸 요청인지 명시
        System.out.println("user-agent :"+req.getHeader("user-agent"));
    }
}
