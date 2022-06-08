<%@ page import="com.web.jsp.domain.dto.MemberDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<body>

<div class="join-page">
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
        <form action="/join" method="post">
            아이디: <input type="text" name="memberId" size="10">
            비밀번호: <input type="password" name="memberPassword" size="20">
            이름: <input type="text" name="memberNick" size="10">
            <label for="memberAuth">권한</label>
            <select id="memberAuth" name="memberAuth" size="1">
                <option value="">선택하세요.</option>
                <option value="STUDENT">학생</option>
                <option value="PROFESSOR">교수</option>
                <input type="submit" value="전송">
                <input type="reset" value="취소">
        </form>
    </div>
</div>

</body>
</html>
