/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.impl;


import controller.AbstractController;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Rottott
 */
public class BoletoController extends  AbstractController{

    @Override
    public void execute() {
        HttpServletRequest request = this.getRequest();
        
            String produto = request.getParameter("produto");
            String preco = request.getParameter("preco");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String numero = request.getParameter("numero");
            String complemento = request.getParameter("complemento");
            String cep = request.getParameter("cep");
            String enderecoNome = request.getParameter("endereco");
               
        this.setReturnPage("/boleto.jsp");
    }
    
    
}
