<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/groDeAndEdStyle.css" />
</head>
<body>

<h1>공지사항 수정</h1>
<h4>공지사항 수정하는 페이지입니다.</h4>



<form action="noticeEditPro.do" method="post" enctype="﻿multipart/form-data">
<table class="tg" style="undefined;table-layout: fixed; width: 1064px">
<colgroup>
<col style="width: 126px">
<col style="width: 938px">
</colgroup>

  <tr>
    <td class="tg-b3sw">제목</td>
    <td class="tg-0lax"> <input name="kmtitle" id="kmtitle" type="text" value="${n.kmtitle }"/>  </td>
  </tr>

  <tr>
    <td class="tg-b3sw">작성자</td>
    <td class="tg-0lax">${n.kmwriter }</td>
  </tr>
  <tr>
    <td class="tg-b3sw">작성일</td>
    
<!--     날짜형식시도... 중. 이곳은 문제 없는듯 -->
   
    <td class="tg-0lax">${n.kmdate } </td>
  </tr>
  <tr>
    <td class="tg-b3sw">첨부파일 </td>
    <td class="tg-0lax">${n.kmfile }</td>
  </tr>
  <tr>
    <td class="tg-cyim" colspan="2"><textarea name="kmcontent" id="textarea" cols="100" rows="30">${n.kmcontent }</textarea></td>
  </tr>

</table>
<input type="hidden" name="kmno" value=${n.kmno } />
<input type="hidden" name="kmwriter" value=${n.kmwriter } />
<input type="hidden" name="kmdate" value=${n.kmdate } />
<input class="bttl" style="margin-left:780px" type="submit" value="수정완료" />

<a href="noticeDetail.do?c=${n.kmno }&cnt=${n.kmcnt }"><input class="bttl" type="button" value="취소" /></a>
</form>

</body>
</html>