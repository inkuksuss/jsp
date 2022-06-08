<%@ page import="com.web.jsp.domain.dto.MemberDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="login-page">
    <header>
        <c:if test="${loginMember != null}">
            <ul>
                <li>
                    <a href="/">홈</a>
                </li>
                <li>
                    <div>${loginMember.memberNick}</div>
                </li>
                <li>
                    <a href="/my-page">마이페이지</a>
                </li>
                <li>
                    <a href="/logout">로그아웃</a>
                </li>
            </ul>
        </c:if>
        <c:if test="${loginMember == null}">
            <ul>
                <li>
                    <a href="/">홈</a>
                </li>
                <li>
                    <a href="/login">로그인</a>
                </li>
                <li>
                    <a href="/join">회원가입</a>
                </li>
            </ul>
        </c:if>
    </header>
    <div class="form-wrapper">
        <form action="/login" method="post">
            아이디: <input type="text" name="memberId" size="10">
            비밀번호: <input type="password" name="memberPassword" size="20">
            <input type="submit" value="전송">&nbsp;&nbsp;&nbsp;<input type="reset" value="취소">
        </form>
    </div>
</div>

</body>
</html>
