<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/groDeAndEdStyle.css" />
</head>
<body>
<div style="padding-top: 50px;">
<h1 >공지사항 글쓰기</h1>
<h4>공지사항 글쓰는 페이지입니다.</h4>
</div>
<!-- 파일 업로드를 위해서 추가해준 부분 : enctype="multipart/form-data -->
<form action="noticeRegPro.do" method="post" enctype="multipart/form-data">
<table class="tg" style="undefined;table-layout: fixed; width: 1064px">
<colgroup>
<col style="width: 126px">
<col style="width: 938px">
</colgroup>

  <tr>
    <td class="tg-b3sw">제목</td>
    <td class="tg-0lax"> <input type="text" id="kmtitle" name="kmtitle"  value=""/>  </td>
  </tr>

  <tr>
    <td class="tg-b3sw">작성자</td>
    <td class="tg-0lax"><input type="text" id="kmwriter" name="kmwriter"  value=""/> </td>
  </tr>
  <tr>
    <td class="tg-b3sw">첨부파일 </td>
    <td class="tg-0lax"><input  type="file" name="kmfile" /></td>
  </tr>
  <tr>
    <td class="tg-cyim" colspan="2"><textarea name="kmcontent" id="textarea" cols="100" rows="30">${n.kmcontent }</textarea></td>
  </tr>

</table>
<input type="hidden" name="kmid" value="${kmid }" />
<input style="margin-left:780px" class="bttl" type="submit" value="완료" />

<a href="noticeMain.do"><input class="bttl" type="button" value="취소" /></a>
</form>


</body>
</html>