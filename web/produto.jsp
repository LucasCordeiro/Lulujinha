<%-- 
    Document   : produto
    Created on : Apr 21, 2015, 7:51:42 PM
    Author     : LucasAugustoCordeiro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lulujinha - o produto que você precisa</title>
    </head>
    <body>
        <jsp:include page="loginHeader.jsp" />
        <hr>
        <div class="produto">  
            <c:set var="produtoP" value="${produto.preco}" />
            <h1>nome:${produto.nome}</h1>
            <img src="${produto.scrImage}" alt="foto do produto">
            <h2>R$${produto.preco}</h2>
            <div class="descricao"> 
                <p>Descrição do produto</p>
                <p>${produto.descricao}</p>
            </div>
            <hr>
            <form action="controller" method="GET">
                <label for="nome">Nome</label>
                <input type="text" name="nome" value="${sessionScope.compradorAtual.nome}" placeholder="Nome completo" readonly="yes">
                <label for="email">Email</label>
                <input type="email" name="email" value="${sessionScope.compradorAtual.email}" placeholder="email@email.com" readonly="yes">
                <br>
                <label for="nome">Endereço</label>
                <input type="text" name="endereco" value="${sessionScope.compradorAtual.endereco.nome}" placeholder="Endereço completo" readonly="yes">
                <label for="nome">Numero</label>
                <input type="number" name="numero" value="${sessionScope.compradorAtual.endereco.numero}" placeholder="Numero" readonly="yes">
                <br>
                <label for="complemento">Complemento</label>
                <input type="text" name="complemento" value="${sessionScope.compradorAtual.endereco.complemento}" placeholder="Complemento">
                <label for="cep">CEP</label>
                <input type="text" name="cep" value="${sessionScope.compradorAtual.endereco.cep}" placeholder="cep" readonly="yes">
                <input type="hidden" name="produto" value="${produto.nome}"
                       <input type="hidden" name="preco" value="${produto.preco}"
                       <br>
                <input type="submit" name="control" value="Boleto"/>         
            </form>

            <%
                request.getSession().setAttribute("Payment_Amount", "10.0");
                request.getSession().setAttribute("PaymentOption", "PayPal");
            %>
            <form action='expresscheckout.jsp' METHOD='POST'>
                <input type='image' name='submit' src='https://www.paypal.com/en_US/i/btn/btn_xpressCheckout.gif' border='0' align='top' alt='Check out with PayPal'/>
            </form>
            
            <hr>
            <a href="controller?control=index"> Voltar </a>
        </div> 
        <jsp:include page="pageFoot.jsp" />
    </body>
</html>
