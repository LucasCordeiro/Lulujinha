<%-- 
    Document   : cadastro
    Created on : Apr 24, 2015, 2:56:11 PM
    Author     : LucasAugustoCordeiro
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
        <div id="cadastroForm">
            <form action="controller" method="POST">
                <label for="nome">Nome:</label><input type="text" name="nome" value="${param.nome}" placeholder="Nome" required="yes"/> <br>

                <label for="email">Email:</label><input type="email" name="email" value="${param.email}" placeholder="Email" required="yes"/><br>

                <label for="endereco">Endereço:</label><input type="text" name="endereco" value="${param.endereco}" placeholder="Endereço" required="yes"/><br>

                <label for="numero">Numero:</label><input type="number" name="numero" value="${param.numero}" placeholder="Numero" required="yes" min="1"/><br>

                <label for="cep">Cep:</label><input type="text" name="cep" value="${param.cep}" placeholder="Cep" required="yes"/><br>

                <label for="complemento">Complemento:</label><input type="text" name="complemento" value="${param.complemento}" placeholder="Complemento"/><br>

                <label for="senha">Senha:</label><input type="password" name="senha" value="" placeholder="Senha" required="yes" minlength="6"/><br>

                <label for="confirmSenha">Comfirma Senha:</label><input type="password" name="confirmSenha" value="" placeholder="Repita a senha" required="yes" minlength="6"/><br>

                <input type="submit" name="control" value="Completar"/> 
                <p>${erroCadastro}</p>
            </form>
        </div>
    </body>
</html>
