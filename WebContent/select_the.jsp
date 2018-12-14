<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
          
          <%
String room =request.getParameter("ID");
%>
<form action="Add_Servlet" method="post">
<!-- 房型选择 -->

<span>房间类型:</span><input type="text" value="<%=room%>" name="ID" readonly="readonly"><br>
<!-- 人员信息填写 -->
<span>姓&nbsp;&nbsp;&nbsp;&nbsp;名:</span><input type="text" name="name"><br>
<span>性&nbsp;&nbsp;&nbsp;&nbsp;别:</span><input type="text" name="sex"><br>
<span>身份证号:</span><input type="text" name="ID_card"><br>

<!--  -->
<input type="submit" value="预定">
</form>
          
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
