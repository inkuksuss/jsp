<%@ page import="com.web.jsp.domain.dto.MemberDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<body>

<div class="insert-board-page">
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
        <form action="/insertBoard" method="post" enctype="multipart/form-data">
            제목: <input type="text" name="boardName" size="10">
            내용: <textarea type="text" name="boardBody" ></textarea>
            <label for="productState">판매상태</label>
            <select id="productState" name="productState" size="1">
                <option value="">선택하세요.</option>
                <option value="N">판매중</option>
                <option value="Y">대기</option>
            </select>
            상품명: <input type="text" name="productName" size="10">
                가격: <input type="number" name="productPrice">
                양: <input type="number" name="productAmount">
<%--                사진: <input type="file" name="productImage">--%>
                <input type="submit" value="전송">
                <input type="reset" value="취소">
        </form>
    </div>
</div>

</body>
</html>
