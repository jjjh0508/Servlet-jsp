package com.jihwan.mvc.employee.model.dto;


import java.sql.Date;

public class EmployeeDTO {

    public EmployeeDTO() {
    }

    public EmployeeDTO(String empId, String empName, String empNo, String email, String deptCode, String salLevel, int salary, double bonus, String managerId, Date hireDate, Date entDate, String entYn, String jobCode) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.email = email;
        this.deptCode = deptCode;
        this.salLevel = salLevel;
        this.salary = salary;
        this.bonus = bonus;
        this.managerId = managerId;
        this.hireDate = hireDate;
        this.entDate = entDate;
        this.entYn = entYn;
        this.jobCode = jobCode;
    }

    private String empId;
    private String empName;

    private String empNo;

    private String email;

    private String deptCode;

    private String salLevel;

    private int salary;

    private double bonus;

    private String managerId;

    private Date hireDate;

    private Date entDate;

    private String entYn;

    private String jobCode;

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public String getEmail() {
        return email;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getSalLevel() {
        return salLevel;
    }

    public int getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public String getManagerId() {
        return managerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Date getEntDate() {
        return entDate;
    }

    public String getEntYn() {
        return entYn;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public void setSalLevel(String salLevel) {
        this.salLevel = salLevel;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setEntDate(Date entDate) {
        this.entDate = entDate;
    }

    public void setEntYn(String entYn) {
        this.entYn = entYn;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empNo='" + empNo + '\'' +
                ", email='" + email + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", salLevel='" + salLevel + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", managerId='" + managerId + '\'' +
                ", hireDate=" + hireDate +
                ", entDate=" + entDate +
                ", entYn='" + entYn + '\'' +
                ", jobCode='" + jobCode + '\'' +
                '}';
    }
}
