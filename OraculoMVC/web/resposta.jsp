<%-- 
    Document   : resposta
    Created on : 19/12/2019, 10:13:25
    Author     : Mariana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resposta melhores produtos</title>
    </head>
    <body>
        <h1>Os melhores produtos do tipo ${produto} são</h1>
        <ul>
            <c:forEach var="item" items="${produtos}">
            <li>   
               ${item}     
            </li>     
             </c:forEach>
                
           
        </ul>
    </body>
</html>
