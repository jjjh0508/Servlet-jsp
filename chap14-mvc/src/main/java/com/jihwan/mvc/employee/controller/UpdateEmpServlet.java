package com.jihwan.mvc.employee.controller;

import com.jihwan.mvc.employee.model.dto.EmployeeDTO;
import com.jihwan.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/update")
public class UpdateEmpServlet extends HttpServlet {
    @Override // form에서 데이터 전송시 post로 전송하기 때문에 해당 메소드가 호출된다.
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String empId = req.getParameter("empId");
        java.sql.Date entDate = java.sql.Date.valueOf(req.getParameter("entDate"));

        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpId(empId);
        emp.setEntDate(entDate);

        int result = new EmployeeService().updateEmp(emp);

        String path = "";
        if (result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode","직원 정보 수정 완료");
        }else {
            path="/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message","회원 정보 수정 실패");
        }

        req.getRequestDispatcher(path).forward(req,resp);
    }
}
