package com.jihwan.mvc.employee.model.service;

import com.jihwan.mvc.employee.model.dao.EmployeeDAO;
import com.jihwan.mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;

import static com.jihwan.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.jihwan.mvc.common.jdbc.JDBCTemplate.close;
import static com.jihwan.mvc.common.jdbc.JDBCTemplate.commit;
import static com.jihwan.mvc.common.jdbc.JDBCTemplate.rollback;

public class EmployeeService {

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

    public String selectNewEmpId() {
        // DB Connection을 생성함
        Connection con = getConnection();
        // 비즈니스 로직 수행
        String newEmpId = empDAO.selectNewEmpId(con);
        //Connection 닫기
        close(con);
        return newEmpId;

    }

    public int insertEmp(EmployeeDTO emp) {
        // Connection
        Connection con = getConnection();
        int result = empDAO.insertEmp(con, emp);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);

        return result;
    }

    public List<EmployeeDTO> selectAllEmp() {
        Connection con = getConnection();
        List<EmployeeDTO> empList = empDAO.selectAllEmp(con);

        close(con);
        return empList;
    }

    public int updateEmp(EmployeeDTO emp) {
        //Connection
        Connection con = getConnection();
        //비즈니스 로직 수행
        int result = empDAO.updateEmp(con, emp);
        if (result > 0) {
            commit(con);
        }else {
            rollback(con);
        }
        close(con);
        return result;
    }
}
