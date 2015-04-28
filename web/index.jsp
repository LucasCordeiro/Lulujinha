<%-- 
    Document   : index
    Created on : Apr 21, 2015, 6:16:39 PM
    Author     : LucasAugustoCordeiro
--%>


<%@page import="models.Avaliacao"%>
<%@page import="models.Produto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lulujinha - A loja que você precisava</title>
    </head>
    <body>
        <jsp:include page="loginHeader.jsp" />    
<!--        <form action="controller">
            <input type="text" required="yes" placeholder="Insira sua busca aqui"/> <input type="submit" name="Buscar">
        </form>    -->
        <div id="resultados">
            <c:forEach var="produto" items="${lista_produtos}">
                <img src="${produto.scrImage}" alt="Foto do produto" height="300" width="300">
                <p>nome:${produto.nome}&nbsp;&nbsp;&nbsp;&nbsp; preço:R$${produto.preco}</p>
                <div class="descricao"> 
                    <p>Descrição do produto</p>
                    <p>${produto.descricao}</p>
                </div>
                <form action="controller" method="GET">
                    <input type="submit" name="control" value="Comprar"/>
                    <input type="hidden" name="produto" value="${produto.nome}"/>
                </form>  
            </c:forEach>   
        </div>
<!--        <div id="botoes"> 
            <a href="" >Prev</a> &nbsp; &nbsp;
            <a href="" >1</a> &nbsp; &nbsp;
            <a href="" >2</a> &nbsp; &nbsp;
            <a href="" >3</a> &nbsp; &nbsp;
            <a href="" >4</a> &nbsp; &nbsp;
            <a href="" >5</a> &nbsp; &nbsp;
            <a href="" >Next</a> &nbsp; &nbsp;
        </div>-->
        
    

        
        <jsp:include page="pageFoot.jsp" />
    </body>
</html>

