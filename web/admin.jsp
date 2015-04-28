<%-- 
    Document   : admin
    Created on : Apr 24, 2015, 5:06:10 PM
    Author     : LucasAugustoCordeiro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adimin</title>
    </head>
    <body>
        <c:if test="${sessionScope.adimSession == null}">
            <c:redirect url="/controller"/>
        </c:if>
        <c:set var="listaDeCompradores" value="${listaDeCompradores}" />
        <table border="1">
                <thead>
                    <tr>
                        <th>Nome: </th>
                        <th>Email: </th>
                        <th>Endereço: </th>
                    </tr>
                </thead>
                <tbody>
        <c:forEach var="comprador" items="${listaDeCompradores}">
                    <tr>
                        <td>${comprador.nome}</td>
                        <td>${comprador.email}</td>
                        <td>${comprador.endereco.nome} ${comprador.endereco.complemento}, ${comprador.endereco.numero} - ${comprador.endereco.cep}</td>
                    </tr>
        </c:forEach>
                </tbody>
            </table>
        
        <a href="controller?control=loggout"> Sair </a>
        </body>
    </html>