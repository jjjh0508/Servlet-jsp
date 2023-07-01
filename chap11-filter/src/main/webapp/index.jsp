<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <ul>
        <li><a href="/first/filter">filter 사용하기 </a> </li>
    </ul>
    <h3>필터의 활용</h3>
    <form action="/member/regist" method="post">
        <div>
            <label>아이디 :</label>
            <input type="text" name="userId"/>
        </div>
        <div>
            <label>비밀번호 : </label>
            <input type="password" name="password"/>
        </div>
        <div>
            <label>이름 :</label>
            <input type="text" name="name"/>
        </div>
        <button type="submit">가입하기</button>
    </form>
</body>
</html>