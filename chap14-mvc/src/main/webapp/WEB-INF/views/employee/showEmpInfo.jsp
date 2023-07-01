<%--
  Created by IntelliJ IDEA.
  User: jjjh0
  Date: 2023-06-30
  Time: 오후 4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>직원 한명 조회</title>
</head>
<body>
  <jsp:include page="../common/header.jsp"/>

  사원 번호 : ${requestScope.selectedEmp.empId} <br>
  사원 명 : ${requestScope.selectedEmp.empName} <br>
  부서코드 : ${requestScope.selectedEmp.deptCode}<br>
  직급코드 : ${requestScope.selectedEmp.jobCode}<br>
  급여 : ${requestScope.selectedEmp.salary}
</body>
</html>
