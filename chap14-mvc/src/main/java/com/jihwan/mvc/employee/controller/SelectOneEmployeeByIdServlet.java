package com.jihwan.mvc.employee.controller;

import com.jihwan.mvc.employee.model.dto.EmployeeDTO;
import com.jihwan.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/select")
public class SelectOneEmployeeByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");



        if(empId.isEmpty()){
            resp.sendError(404,"잘못된 아이디 입니다.");
        }

        //비즈니스 로직 호출
        EmployeeService empService = new EmployeeService();
        EmployeeDTO selectEmp = empService.selectOneEmpById(empId);

        System.out.println("selectEmp : "+selectEmp);

        String path ="";

        if (selectEmp != null) {
            // 사용자에게 보여줄 화면의 경로를 지정한다.
            path = "/WEB-INF/views/employee/showEmpInfo.jsp";
            //front화면에서 값을 꺼내올때 아래의 key기준으로 꺼내온다.
            req.setAttribute("selectedEmp",selectEmp);
        }else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message","직원 정보 조회 실패");
        }
        req.getRequestDispatcher(path).forward(req, resp);


    }
}
