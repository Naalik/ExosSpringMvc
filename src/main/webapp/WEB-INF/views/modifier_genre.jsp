<%-- 
    Document   : modifier_genre
    Created on : 10 oct. 2016, 14:43:14
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modifier</h1>
        <c:set var="route"><spring:url value="/editer_genre"/></c:set>
        <form:form action="${route}" modelAttribute="genre" method="POST">
            <label title="Nom :" /><form:input path="nom"/><br/>
            <form:hidden path="id"/><br/>
            <input type="submit" value="Modifier"/>
        </form:form>
    </body>
</html>
