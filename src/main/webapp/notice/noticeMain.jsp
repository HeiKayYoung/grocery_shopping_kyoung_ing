<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gro noticeMain</title>

<link rel="stylesheet" href="../css/groNoticeMainStyle.css" />

<script>
	function clearVal() {
		var inputVal = document.getElementById("s");
		inputVal.value = "";
	}
</script>

</head>
<body>
	<a href="../index.jsp">Home</a>
	<h1>공지사항</h1>



	<h5 style="color: gray;">컬리의 새로운 소식들과 유용한 정보들을 한곳에서 확인하세요.</h5>
	<div class="tb">
		<table class="tg" style="table-layout: fixed; width: 1000px">
			<colgroup>
				<col style="width: 67px">
				<col style="width: 612px">
				<col style="width: 97px">
				<col style="width: 101px">
				<col style="width: 56px">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목 </th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>           
			</thead>
			<tbody>
				<tr>
					<td>공지</td>
					<td>[안내]컬리 소비자 분쟁해결 기준 안내</td>
					<td>컬리</td>
					<td>2022.07.27</td>
					<td>0</td>
				</tr>
				<c:forEach items="${blist }" var="n">
					<tr>
						<td>${n.kmno }</td>
						<td><a href="noticeDetail.do?c=${n.kmno }&cnt=${n.kmcnt }">${n.kmtitle }</a></td>
						<td>${n.kmwriter }</td>
						<td>${n.kmdate }</td>
						<td>${n.kmcnt }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<div class="rt">
		<!-- 세션에 아이디 담겨있을시(로그인 상태)에만 글쓰기 가능 -->
		<c:if test="${not empty sessionScope.kmid }">
			<a href="noticeReg.do"><input type="button" value="글쓰기"></a>
		</c:if>
	</div>
	<div>
		<!-- 검색기능 -->
		<form action="noticeMain.do" method="get" class="sc">
			<select name="f">
				<!-- 삼항연산자를 활용해서 제목. 내용을 selected 해서 화면에서 고정되게끔 해준다 -->
				<option value="kmtitle" ${param.f=="kmtitle"?"selected":"" }>제목</option>
				<option value="kmcontent" ${param.f=="kmcontent"?"selected":"" }>내용</option>

			</select> <input type="text" name="s" value="${search }" id="s"
				onclick="clearVal()" /> <input type="submit" value="검색" />
		</form>
	</div>
	</div>
</body>
</html>