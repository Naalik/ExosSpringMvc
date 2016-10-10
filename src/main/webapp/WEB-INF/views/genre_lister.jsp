<%-- 
    Document   : genre_lister
    Created on : 10 oct. 2016, 11:05:24
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Liste</h1>
        <c:forEach items = "${genres}" var = "genre">
            ${genre.nom}<br/>
        </c:forEach>
        
    </body>
</html>
