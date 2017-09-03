<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<tiles:insertAttribute name="header"/>
<input type="button" value="입력" onclick="javascript:goInsert();">
<form name="formf" method="post">
<input type="hidden" id="testNo" name="no">
<input type="hidden" id="testNo" name="pageNo" value="${pageNo}">
<input type="hidden" id="testName" name="testName">
<div id="ins">
	<table>
	<c:forEach items="${test}" var="dto">
		<tr id="test_${dto.no}"><td><c:out value="${dto.no}"/></td>
			<td>${dto.name}</td>
			<td>${dto.todaydate}</td>
			<td><input type="button" value="수정" onclick="javascript:goUpdate('${dto.no}');"></td>
			<td><input type="button" value="삭제" onclick="javascript:goDelete('${dto.no}');"></td>
		</tr>
		<tr id="testup_${dto.no}" style="display:none;"><td>${dto.no}</td>
			<td><input type="text" id="name_${dto.no}" name="name" value="${dto.name}"/></td>
			<td>${dto.todaydate}</td>
			<td><input type="button" id="goUp" value="수정" onclick="javascript:goSubmit();"></td>
			<td><input type="button" value="취소" onclick="javascript:goCencle('${dto.no}');"></td>
		</tr>
	</c:forEach>
	</table>
</div>
<div>
	<table>	
		<tr>
			<td>
				<c:forEach var="i" begin="1" end="${pagesu}" step="1">
					<c:set value="${pageNo}" var="pageNo"/>
					<c:choose>
						<c:when test="${i == pageNo}">
							<b>${i}</b>
						</c:when>
						<c:otherwise>
							<a href="/list?pageNo=${i}">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</td>
		</tr>
	</table>
</div>
</form>
<tiles:insertAttribute name="footer"/>
</body>
</html>
<script>
	function goInsert(){
		location.href='/insert';
	}
	function goDelete(no){
		$('#testNo').val(no);
		var formf = document.formf;
		formf.action = "/delete";
		formf.submit();		
	}
	function goSubmit(){
		var f = document.formf;
		f.action = "/update";
		$('#testName').val($('#name_'+$('#testNo').val()).val());
		f.submit();
	}
	function goUpdate(no){
		$('#testNo').val(no);
		$('#goUp').show();
		$('#test_'+no).hide();
		$('#testup_'+no).show();
	}
	function goCencle(no){
		$('#testNo').val('');
		$('#goUp').hide();
		$('#testup_'+no).hide();
		$('#test_'+no).show();
	}
</script>