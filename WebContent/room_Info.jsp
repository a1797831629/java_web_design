<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>酒店后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
  
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">校园宿舍管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="left.jsp"%>
          </td>
          <td width="709" align="center" valign="middle" bgcolor="#F6F9FE">
          
          
          
          <table>
<tr>
<th>房间ID</th>
<th>房间类型</th>
<th>价格</th>
<th>住户性别</th>
<th>住户身份ID</th>

</tr>
<c:if test="${!empty goodsList}">
	<c:forEach items="${goodsList}" var="goods" varStatus="i">
	<tr>
		<td><c:out value="${goods.ID}"></c:out></td>
		
		<td><c:out value="${goods.context}"></c:out></td>
		<td><c:out value="${goods.price}"></c:out></td>
		<td><c:out value="${goods.name}"></c:out></td>
		<td><c:out value="${goods.sex}"></c:out></td>
		<td><c:out value="${goods.ID_card}"></c:out></td>
		
		<!-- ?ID=<c:out value="${goods.ID}"></c:out> -->
	</tr>
	</c:forEach>
</c:if>

</table>
<a href="manage.jsp">返回上一级</a>
          
          
          
          </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>



