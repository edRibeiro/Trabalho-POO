<%-- 
    Document   : exibearquivo
    Created on : 26/12/2015, 08:41:50
    Author     : ederson
--%>
<%
    HttpSession sessao = request.getSession();

    String nome = "";
    nome = (String) sessao.getAttribute("imagem");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload Example in JSP and Servlet - Java web application</title>
    </head>

    <body> 
        <div id="result">
            <h3>${requestScope["message"]}</h3>
            <h3><%=nome%></h3>

            <img src="<%=nome %>"/>






        </div>

    </body>
</html>

