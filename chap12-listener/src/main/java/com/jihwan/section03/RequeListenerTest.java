package com.jihwan.section03;


import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
/*3-2. Request Listener*/
@WebListener
public class RequeListenerTest implements ServletRequestListener, ServletRequestAttributeListener {

    public RequeListenerTest() {
        // was가 실행될때 리스너를 생성한다.

        System.out.println("request listener 인스턴스 생성");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        //request에 attribute가 추가 될 떄 호출된다.

        System.out.println("request attribute added!");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        //request에 attribute가 제거될 떄 호출된다.
        System.out.println("request attribute Removed!!");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        //  reqeust에 attribute가 수정 될때 호출된다
        /*
        * org.apache.catalina.ASYNC_SUPPORTED라는 attribute가 자동으로 수정되기 때문에 한 번 호출은 된다.
        * 서블릿 3.0에서 부터 비동기 방식의 요청 처리를 지원하는 다는 내용이니 너무 신경 쓰지 말자
        * */
        System.out.println("request attribute Replaced");
        System.out.println(srae.getName()+", "+srae.getValue());
    }



    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // request 요청이 소멸될 때 호출된다
        System.out.println("request Destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // request가 생성될떄 호출된다
        System.out.println("request Initialized");
    }
}
