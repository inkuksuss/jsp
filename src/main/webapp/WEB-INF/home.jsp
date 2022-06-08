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
        <a href="/insertBoard">작성하기</a>
    </div>
        <c:forEach items="${boardList}" var="board">
            <a href="/board/${board.boardIdx}">
                <th>작성자: ${board.memberNick}</th>
                <th>제목: ${board.boardName}</th>
                <th>내용: ${board.boardBody}</th>
                <th><img src="${board.productImage}"</th>
            </a>
        </c:forEach>
    </table>
</div>

</body>
</html>
