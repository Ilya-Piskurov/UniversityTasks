<%-- 
    Document   : index
    Created on : 14 груд. 2022 р., 15:11:14
    Author     : Illia Piskurov
--%>

<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        h1 {
            text-align: center;
        }
        #page {
            width: 800px;
            margin: auto;
        }
        form {
            width: 400px;
            margin: auto;
        }
        input[type=submit] {
            margin: auto;
        }
        body {
            background: rgb(180,58,123);
            background: linear-gradient(90deg, rgba(180,58,123,1) 0%, rgba(253,156,29,1) 50%, rgba(69,252,237,1) 100%); 
        }
    </style>
    <body>
        <div id="page">
            <form method="post">
                <table>
                    <tbody>
                        <tr>
                            <td><label for="name">Name</td>
                            <td><input id="name" type="text" name="name"></td>
                        </tr>
                        <tr>
                            <td><label for="surname">Surname</td>
                            <td><input id="surname" type="text" name="surname"></td>
                        </tr>
                        <tr>
                            <td><label for="email">Email</td>
                            <td><input id="email" type="text" name="email"></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" name="send" value="Send">
            </form>
            <c:if test="${not empty param.send}">
                <c:set var="id" value="${id+1}" scope="application"/>
                
                <c:if test="${not empty param.name}">
                    <c:set var="name" value="${param.name}" scope="session"/>
                    <p>
                        Name: ${param.name}
                    </p>
                </c:if>
                <c:if test="${not empty param.surname}">
                    <c:set var="surname" value="${param.surname}" scope="session"/>
                    <p>
                        Surname: ${param.surname}
                    </p>
                </c:if>    
                <c:if test="${not empty param.email}">
                    <c:set var="email" value="${param.email}" scope="session"/>
                    <p>
                        Email: ${param.email}
                    </p>
                </c:if>    
            </c:if>
        </div>
    </body>
</html>
