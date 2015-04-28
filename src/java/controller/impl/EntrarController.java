/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.impl;

import controller.AbstractController;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.Comprador;
import models.Endereco;
import models.Produto;
import persistence.CompradorDAO;
import persistence.ProdutoDAO;

/**
 *
 * @author LucasAugustoCordeiro
 */
public class EntrarController extends AbstractController {

    @Override
    public void execute() {

        HttpServletRequest request = this.getRequest();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        ProdutoDAO prod = new ProdutoDAO();
        List<Produto> lista_produtos = new <Produto>ArrayList();
        lista_produtos = prod.listar();

        request.setAttribute("lista_produtos", lista_produtos);

        this.setReturnPage("/index.jsp");
        request.setAttribute("erroLogin", "Login ou senha inválidos");

        CompradorDAO compr = new CompradorDAO();
        List<Comprador> listaComprador = new ArrayList();
        listaComprador = compr.listar();
       

        
        if (login.equals("admin") && senha.equals("lulujinha")) {
            request.getSession().setAttribute("adimSession", "yes");
            this.setReturnPage("/admin.jsp");
            request.setAttribute("erroLogin", "");
            request.setAttribute("listaDeCompradores", listaComprador);
        }

        for (Comprador comp : listaComprador) {
            if (comp.getEmail().equals(login) && comp.getSenha().equals(senha)) {
                request.getSession().setAttribute("compradorAtual", comp);
                this.setReturnPage("/index.jsp");
                request.setAttribute("erroLogin", "");
            }
        }

    }

}
