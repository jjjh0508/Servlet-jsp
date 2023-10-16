package com.jihwan.mvc.employee.model.dao;

import com.jihwan.mvc.common.config.ConfigLocation;
import com.jihwan.mvc.employee.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.jihwan.mvc.common.jdbc.JDBCTemplate.close;

public class EmployeeDAO {
    private final Properties prop;

    public EmployeeDAO() {
        prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "employee-mapper.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public EmployeeDTO selectEmpById(Connection con, String empId) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        EmployeeDTO selectEmp = null;

        String query = prop.getProperty("selectEmpById");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                selectEmp = new EmployeeDTO();
                selectEmp.setEmpId(rset.getString("EMP_ID"));
                selectEmp.setEmpName(rset.getString("EMP_NAME"));
                selectEmp.setDeptCode(rset.getString("DEPT_CODE"));
                selectEmp.setJobCode(rset.getString("JOB_CODE"));
                selectEmp.setSalary(rset.getInt("SALARY"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);

        }

        return selectEmp;

    }

    public String selectNewEmpId(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rest = null;

        String newEmpId = null;
        String query = prop.getProperty("selectNewEmpId");

        try {
            pstmt = con.prepareStatement(query);
            rest = pstmt.executeQuery();
            if (rest.next()) {
                newEmpId = rest.getString("NEXTVAL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rest);
            close(pstmt);
        }
        return newEmpId;

    }

    public int insertEmp(Connection con, EmployeeDTO emp) {
        PreparedStatement pstmt = null;

        int result = 0;
        String query = prop.getProperty("insertEmp");
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, emp.getEmpId());
            pstmt.setString(2, emp.getEmpName());
            pstmt.setString(3, emp.getEmpNo());
            pstmt.setString(4, emp.getEmail());
            pstmt.setString(5, emp.getPhone());
            pstmt.setString(6, emp.getDeptCode());
            pstmt.setString(7, emp.getJobCode());

            pstmt.setInt(8, emp.getSalary());
            pstmt.setDouble(9, emp.getBonus());
            pstmt.setString(10, emp.getManagerId());
            pstmt.setDate(11, emp.getHireDate());
            // 반환 데이터는 int 값이다.
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);

        }

        return result;
    }

    public List<EmployeeDTO> selectAllEmp(Connection con) {
        Statement stmt = null;
        ResultSet rest = null;

        List<EmployeeDTO> empList = null;

        String query = prop.getProperty("selectAllEmp");
        try {
            stmt = con.createStatement();
            rest = stmt.executeQuery(query);

            empList = new ArrayList<>();

            while (rest.next()) {
                EmployeeDTO emp = new EmployeeDTO();
                emp.setEmpId(rest.getString("EMP_ID"));
                emp.setEmpName(rest.getString("EMP_NAME"));
                emp.setEmpNo(rest.getString("EMP_NO"));
                emp.setEmail(rest.getString("EMAIL"));
                emp.setPhone(rest.getString("PHONE"));
                emp.setDeptCode(rest.getString("DEPT_CODE"));
                emp.setJobCode(rest.getString("JOB_CODE"));
                emp.setSalary(rest.getInt("SALARY"));
                emp.setSalLevel(rest.getString("SAL_LEVEL"));
                emp.setBonus(rest.getDouble("BONUS"));
                emp.setManagerId(rest.getString("MANAGER_ID"));
                emp.setHireDate(rest.getDate("HIRE_DATE"));
                emp.setEntYn(rest.getString("ENT_YN"));

                empList.add(emp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rest);
            close(stmt);

        }

        return empList;
    }

    public int updateEmp(Connection con, EmployeeDTO emp) {
        PreparedStatement pstmt = null;

        String query = prop.getProperty("updateEmp");
        int result = 0;
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setDate(1, emp.getEntDate());
            pstmt.setString(2, emp.getEmpId());
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }
}
