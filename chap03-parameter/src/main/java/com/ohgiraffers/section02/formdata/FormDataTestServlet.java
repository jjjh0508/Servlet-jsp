package com.ohgiraffers.section02.formdata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* post 방식으로 전달 받은 데이터에 한글이 포함되어 있으면 해당 문자는 인코딩이 맞지 않아 깨진다.
        *  get 방식의 데이터는 html charset에 기술된 인코딩 방식으로 브라우저가 한글을 이해하고 %문자로
        *  urlEncoder를 이용해 변환 후 url 요청으로 전송한다. 이 때 header의 내용은 ascii코드 전송 되기 떄문에
        *  어떤 언어이든 서버의 설ㅈ어 인코딩 방식과 맞기만 ㅏㅎ면 해석하는데 문제가 없으므로 한굴이 깨지지 않는다.
        * get의 요청은 보통 서버의 리소스를 가져오는 행위를 하는 http 요청 방식이기에 별도의 데이터가 필요없어
        *  요청 본문(페이로드)는 해석하지 않는다.
        * 하지만 post 요청은 서버의 리소스에 내용을 추가하는 요청이기 떄문에  요청하는 데이터가 필요한 경우가 대부분이다.
        *  서버의 리소스에 추가해야하는 정보를 페이로드에 key & value 방식으로 담아 전송하는데
        *  헤더와는 별개로 urlEncoder를 이용하지 않고 페이지 mata에 기술된 chartset에 따라 utf-8로 해석된 데이터를 서버로 전송한다
        *  인코딩된 방식을 명시하지 않으면 기본 ios-8859-1로 해석하므로 값을 꺼내오면 한글인 글자가 깨지는 현상이 발생한다.
        *  따라서 parameter를 꺼내오기 전에 parameter 값을 해석할 인코딩 방식이 UTF-8임을 setScharterEncodeing(String encType)으로 지정해줘야한다
        * 브라우저에 요청한 인코ㅓ딩 방식와 일치하여 한글 깨짐 현상을 막을 수 있다.
        *
        * */

        System.out.println(req.getCharacterEncoding());
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        System.out.println("name : "+name);


        Map<String,String[]> reqMap =  req.getParameterMap();
        Set<String> ketSet = reqMap.keySet();
        Iterator<String> keyIter = ketSet.iterator();
        while (keyIter.hasNext()){
            String key = keyIter.next();
            String[] valStrings = reqMap.get(key);

            System.out.println("key : "+key);

            for (int i=0;i<valStrings.length;i++){
                System.out.println("value["+i+"] : "+valStrings[i]);
            }
        }

        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()){
            System.out.println(names.nextElement());
        }


    }
}
