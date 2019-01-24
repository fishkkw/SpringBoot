<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Cookie[] cook= request.getCookies();
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
  </head> 
  <body>   
  ${msg}
      <form action="/login/b" id="regloginform" method="POST">
      	<input type="text" name="id" value="${account.id}">
      	<button type="submit">访问</button>
      </form>
  </body> 
</html>
