package com.jihwan.mvc.employee.controller;

import com.jihwan.mvc.employee.model.dto.EmployeeDTO;
import com.jihwan.mvc.employee.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/insert")
public class InsertEmpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // post 요청의 경우 한글이 깨지는것은 request 챕터에 있다.
        //사용자의 요청값을 꺼냄
        req.setCharacterEncoding("UTF-8");
        String empName = req.getParameter("empName");
        String empNo = req.getParameter("empNo");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String deptCode = req.getParameter("deptCode");
        String jobCode = req.getParameter("jobCode");
        int salary = Integer.parseInt(req.getParameter("salary"));
        double bonus = Double.parseDouble(req.getParameter("bonus"));
        String managerId = req.getParameter("managerId");
        java.sql.Date hireDate = java.sql.Date.valueOf(req.getParameter("hireDate"));

        //유효성 검사
        EmployeeService empService = new EmployeeService();
        String newEmpId = empService.selectNewEmpId();
        String path = "";


        EmployeeDTO emp = new EmployeeDTO();
        if (newEmpId != null) {
            emp.setEmpId(newEmpId);
            emp.setEmpName(empName);
            emp.setEmpNo(empNo);
            emp.setEmail(email);
            emp.setPhone(phone);
            emp.setDeptCode(deptCode);
            emp.setJobCode(jobCode);
            emp.setSalary(salary);
            emp.setBonus(bonus);
            emp.setManagerId(managerId);
            emp.setHireDate(hireDate);


            System.out.println("emp 값 조회"+emp);

            int result = empService.insertEmp(emp);

            if (result > 0) {
                path = "/WEB-INF/views/common/successPage.jsp";
                req.setAttribute("successCode","직원 등록에 성공");


            }else {
                path = "/WEB-INF/views/common/errorPage.jsp";
                req.setAttribute("message","직원 동록에 실패하였습니다.");
            }
        }else{
            resp.sendError(500,"사용자 인덱스 호출 오류");
        }

        req.getRequestDispatcher(path).forward(req,resp);


    }
}
