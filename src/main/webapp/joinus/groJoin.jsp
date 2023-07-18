<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/groJoinFormStyle.css" />
</head>
<body>

	<!-- 중앙정렬해두려고 마련해둔 div-->
	<div id="wrap">
		<form action="groJoinPro.do" method="post">
			<table class="tg" style="table-layout: fixed; width: 775px">
				<colgroup>
					<col style="width: 181px">
					<col style="width: 131px">
					<col style="width: 147px">
					<col style="width: 156px">
					<col style="width: 160px">
				</colgroup>
				<thead>
					<tr>
						<th class="tg-y0kz" colspan="5"><span
							style="font-weight: bold">회원가입</span></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="tg-xtqg" colspan="5"><span style="color: #CB0000">*</span>필수입력사항</td>
					</tr>
					<tr>
						<td class="tg-fymr">아이디<span style="color: #9A0000">*</span></td>
						<td class="tg-0pky" colspan="3"><input type="text"
							name="kmid" size="50" required="required" /></td>
						<td class="tg-0pky" id="opky"><input type="button"
							value="중복확인" /></td>
					</tr>
					<tr>
						<td class="tg-fymr">비밀번호<span style="color: #CB0000">*</span></td>
						<td class="tg-0pky" colspan="3"><input type="password"
							name="kmpwd1" size="50" required="required" /></td>
						<td class="tg-0pky"></td>
					</tr>
					<tr>
						<td class="tg-fymr">비밀번호확인<span style="color: #CB0000">*</span></td>
						<td class="tg-0pky" colspan="3"><input type="password"
							name="kmpwd2" size="50" required="required" /></td>
						<td class="tg-0pky">
							
							<%-- <% 비밀번호 체크 진행중
							String pwdcheck = (String) request.getAttribute("pwdcheck");
							%> <%
 									if (pwdcheck != null && !pwdcheck.isEmpty()) {
 								%>
							<p><%=pwdcheck%></p> <%
 								}
 								%> --%>
						</td>
					</tr>
					<tr>
						<td class="tg-fymr">이름<span style="color: #CB0000">*</span></td>
						<td class="tg-0pky" colspan="3"><input type="text"
							name="kmname" size="50" required="required" /></td>
						<td class="tg-0pky"></td>
					</tr>
					<tr>
						<td class="tg-fymr">이메일</td>
						<td class="tg-0pky" colspan="3"><input type="text"
							name="kmemail" size="50" /></td>
						<td class="tg-0pky">중복확인</td>
					</tr>
					<tr>
						<td class="tg-fymr">휴대폰</td>
						<td class="tg-0pky" colspan="3"><input type="text"
							name="kmcellphone" size="50" /></td>
						<td class="tg-0pky">인증번호받기</td>
					</tr>
					<tr>
						<td class="tg-fymr">주소</td>
						<td class="tg-0pky" colspan="3"><input type="text"
							name="kmaddr" size="50" /></td>
						<td class="tg-0pky"></td>
					</tr>
					<tr>
						<td class="tg-fymr">성별</td>
						<td class="tg-0pky"><input type="radio" name="kmgender"
							value="male" />남자</td>
						<td class="tg-0pky"><input type="radio" name="kmgender"
							value="female" />여자</td>
						<td class="tg-0pky"><input type="radio" checked="checked"
							name="kmgender" value="non" />선택안함</td>
						<td class="tg-0pky"></select></td>
					</tr>
					<tr id="child">
						<td class="tg-fymr">생년월일<span style="color: #CB0000">*</span></td>
						<td class="tg-0pky" colspan="3"><input type="date"
							name="kmbirthday" required="required" /></td>
						<td class="tg-0pky"></td>
					</tr>
				</tbody>
			</table>
			<input class="aa" id="aaa" type="submit" value="회원가입" /> <a
				href="../index.jsp"> <input class="aa" type="button" value="취소" /></a>
		</form>
	</div>

</body>
</html>