<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/groLoginFormStyle.css" />

</head>
<body>
	<a href="../index.jsp">Home</a>

	<div class="hole">

		<form action="loginFormPro.do" name="loginInfo" method="post">

			<table class="tbb">
				<tr>
					<td><b>로그인</b></td>
				</tr>
				<tr>
					<td><input data-testid="input-box" name="kmid"
						placeholder="아이디를 입력해주세요" type="text"
						style="width: 250px; height: 30px;"></td>
				</tr>

				<tr>
					<td><input data-testid="input-box" name="kmpwd1"
						placeholder="비밀번호를 입력해주세요" type="password" autocomplete="off"
						style="width: 250px; height: 30px;"></td>
				</tr>

				<tr>
					<td style="text-align: right; font-size: x-small;"><a>아이디
							찾기</a>|<a>비밀번호 찾기</a></td>
				</tr>

				<tr>
					<td><input type="submit" value="로그인" class="pup1"></td>
				</tr>
				<tr>
					<td>
						<div class="pup2">
							<a href="../joinus/groJoin.do"><span
								style="color: purple; font-size: 13px;">회원가입</span></a>
						</div>
					</td>
				</tr>

			</table>

		</form>

		<%
		String error = (String) request.getAttribute("error");
		%>
		<%
		if (error != null && !error.isEmpty()) {
		%>
		<p><%=error%></p>
		<%
		}
		%>


	</div>
</body>
</html>