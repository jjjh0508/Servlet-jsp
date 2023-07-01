package com.jihwan.mvc.employee.model.service;

import com.jihwan.mvc.employee.model.dao.EmployeeDAO;
import com.jihwan.mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.util.Objects;

import  static com.jihwan.mvc.common.jdbc.JDBCTemplate.getConnection;
import  static com.jihwan.mvc.common.jdbc.JDBCTemplate.close;

public class EmployeeService  {

    private final EmployeeDAO empDAO;

    public EmployeeService() {
        empDAO = new EmployeeDAO();
    }

    public EmployeeDTO selectOneEmpById(String empId) {
        // DB Connection 생성
        Connection con = getConnection();
        //비즈니스 로직을 수행
        EmployeeDTO selectEmp = empDAO.selectEmpById(con, empId);
        // DB를 닫아준다.
        close(con);

        return selectEmp;
    }
}
