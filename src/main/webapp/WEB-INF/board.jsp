<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<body>
<div class="home-page">
    <header>
        <c:if test="${loginMember != null}">
            <ul>
                <li>
                    <div>${loginMember.memberNick}</div>
                </li>
                <li>
                    <a href="/">홈</a>
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
        <div>제목: ${board.boardName}</div>
        <div>내용: ${board.boardBody}</div>
        <div>상품가격: ${board.productPrice}</div>
        <div>잔여량: ${board.productAmount}</div>
        <img src="${board.productImage}">
    </div>
    </table>
</div>

</body>
</html>
