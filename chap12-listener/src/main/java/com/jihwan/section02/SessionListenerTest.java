package com.jihwan.section02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/*2-2. session Listener */
@WebListener
public class SessionListenerTest implements HttpSessionListener , HttpSessionAttributeListener {
    static int userCnt = 0;

    public SessionListenerTest() {

        System.out.println("session Listener 인스턴스 생성");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        //session 속성이 추가될때 이벤트를 감지함
        System.out.println("session attribute added!");
        System.out.println("session에서 추가된 attr : "+event.getName()+", "+event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        //session 속성이 제거 될떄 이벤트를 감지함
        System.out.println("session attribute Removeed!");
        System.out.println("session에서 제거된 attr : "+event.getName()+", "+event.getValue());

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        //session이 수정될 떄 실행된다.
        System.out.println("session attribute replaced!");
        System.out.println("session에서 수정된 attr : "+event.getName()+","+event.getValue());
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        userCnt++;
        //session이 생성되면 실행된다.
        System.out.println("session created");
        System.out.println("생성된 session id : "+se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        userCnt--;
        //세션이 소멸될때 실행된다.
        System.out.println("session destroyed!! ");
    }

}
