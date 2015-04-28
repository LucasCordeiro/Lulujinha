<%-- 
    Document   : testePayPal
    Created on : Apr 26, 2015, 9:30:53 PM
    Author     : LucasAugustoCordeiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.getSession().setAttribute("Payment_Amount", "20.00");
            request.getSession().setAttribute("PaymentOption", "PayPal");
        %>
        <form action='expresscheckout.jsp' METHOD='POST'>
            <input type='image' name='submit' src='https://www.paypal.com/en_US/i/btn/btn_xpressCheckout.gif' border='0' align='top' alt='Check out with PayPal'/>
        </form>


    </body>
</html>
