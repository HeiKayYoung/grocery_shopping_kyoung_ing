<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<link rel="stylesheet" href="./css/groIndexStyle.css" />
	<!-- 로그인 로그아웃 session상태에 따라 다르게 보이게 만들기 -->
	<!-- if문 안에 들어갔다나는 것을 생각해서 True 냐 false냐를 물어야하니까 empty냐? 라고 묻는것 -->
	<div id="lfd">
		<c:if test="${empty sessionScope.kmid }">
			<a href="joinus/groJoin.do">회원가입</a> |
			<a href="login/loginForm.do">로그인</a> |
		</c:if>
		<c:if test="${not empty sessionScope.kmid }">
			<a href="login/logoutPro.do">로그아웃</a> |
		</c:if>

		<a href="notice/noticeMain.do">공지사항</a>
	</div>
	<div>
		<p>
			컬리컬리 <span>마켓컬리</span><span>|</span><span>뷰티컬리</span> <input
				type="text" />
		</p>
	</div >
	<p>카테고리</p>
	<hr />
	<table>
		<tr>
			<td>여기에는 배너가 ~ </td>
		</tr>
	</table>

</body>
</html>