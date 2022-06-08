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

<div class="my-page">
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
    <div>
        <div>이름: ${loginMember.memberNick}</div>
        <div>아이디: ${loginMember.memberId}</div>
        <div>가입일: ${loginMember.dateReg}</div>
        <div>권한: ${loginMember.memberAuth}</div>
        <a href="/deleteMember">계정삭제</a>
    </div>
</div>

</body>
</html>
