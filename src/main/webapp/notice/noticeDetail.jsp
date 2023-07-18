<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/groDeAndEdStyle.css" />

</head>


<body>
	<div id="ttb">
		<div id="tto">
			<h1>공지사항</h1>
			<h4 style="color: gray;">컬리의 새로운 소식들과 유용한 정보들을 한곳에서 확인하세요.</h4>
		</div>
		<div>
			<table class="tg" style="width: 1064px">
				<colgroup>
					<col style="width: 126px">
					<col style="width: 938px">
				</colgroup>
				<thead>
					<tr>
						<td class="tg-b3sw">제목</td>
						<td class="tg-0lax">${n.kmtitle }</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="tg-b3sw">작성자</td>
						<td class="tg-0lax">${n.kmwriter }</td>
					</tr>
					<tr>
						<td class="tg-b3sw">작성일</td>
						<td class="tg-0lax"><fmt:formatDate pattern="yyyy-MM-dd"
								value="${n.kmdate }" /></td>
					</tr>
					<tr>
						<td class="tg-b3sw">첨부파일</td>
						<!--     파일 이름으로 이 파일을 찾겠다 -->
						<td class="tg-0lax"><a
							href="download.do?p=notice/upload/&f=${n.kmfile }">${n.kmfile }</a>

						</td>
					</tr>
					<tr>
						<td class="tg-cyim" colspan="2"><textarea name="textarea"
								id="textarea" readonly="readonly">${n.kmcontent }</textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="btt">
			<!-- 세션에 아이디 담겨있을시(로그인 상태)에만 수정,삭제 가능 -->
			<c:if test="${not empty sessionScope.kmid }">
				<a href="noticeEdit.do?c=${n.kmno }"><input type="button"
					value="수정" /></a>
				<a href="noticeDelete.do?c=${n.kmno }"><input type="button"
					value="삭제" /></a>
			</c:if>

			<a href="noticeMain.do"><input type="button" id="pl" value="목록" /></a>
		</div>
		<hr />
	</div>



</body>
</html>