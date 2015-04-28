<%-- 
    Document   : loginHeader
    Created on : Apr 21, 2015, 7:55:35 PM
    Author     : LucasAugustoCordeiro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Header </title>
    </head>
    <body>
        <header>
            <c:choose>
                <c:when test="${sessionScope.compradorAtual!=null}">
                    BEM-VINDO ${sessionScope.compradorAtual.nome}
                    <a href="controller?control=loggout"> Sair </a>
                </c:when>
                <c:otherwise>
                    <form action="controller" method="POST">
                        <input type="text" name="login" placeholder="email" />
                        <input type="password" name="senha" placeholder="senha" />
                        <input type="submit" value="Entrar"  name="control"/>
                        <input type="submit" value="Cadastrar-se" name="control"/> ${erroLogin}
                    </form>
                </c:otherwise>
            </c:choose>
        </header>
    </body>
</html>
