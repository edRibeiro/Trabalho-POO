<%-- 
    Document   : home
    Created on : 26/12/2015, 07:41:53
    Author     : ederson
    Modificado : 31/12/2015
--%>
<%
    String nome = request.getParameter("nome");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bem vindo! <%=nome%></h1>
        <form action="upload" method="post" enctype="multipart/form-data">

                <input type="file" name="file" />

                <input type="submit" value="upload" />

            </form>    




    </body>
</html>
