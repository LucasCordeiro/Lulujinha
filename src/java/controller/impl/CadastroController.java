/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.impl;

import controller.AbstractController;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
public class CadastroController extends AbstractController {
    
    @Override
    public void execute() {
        HttpServletRequest request = this.getRequest();
        String finalidade = (String) request.getParameter("control");

        if (finalidade.equalsIgnoreCase("Completar")) {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String numero = request.getParameter("numero");
            String complemento = request.getParameter("complemento");
            String cep = request.getParameter("cep");
            String enderecoNome = request.getParameter("endereco");
            String senha = request.getParameter("senha");
            String confirmSenha = request.getParameter("confirmSenha");

            if (senha.equals(confirmSenha)) {
                Endereco endereco = new Endereco(enderecoNome, numero, complemento, cep);
                Comprador comprador = new Comprador(nome, email, endereco, senha);
       
                CompradorDAO compr = new CompradorDAO();
                compr.inserir(comprador);
                
                ProdutoDAO prod = new ProdutoDAO();
                List<Produto> lista_produtos = new <Produto>ArrayList();
                lista_produtos = prod.listar();
                
                request.setAttribute("lista_produtos", lista_produtos);
                request.getSession().setAttribute("compradorAtual", comprador);
               //
                //INDEX
//                List lista_produtos = iPersistence.list(Produto.class);
//                request.getSession().setAttribute("lista_produtos", lista_produtos);
                this.setReturnPage("/index.jsp");
            } else {
                request.setAttribute("erroCadastro", "Senha incorreta");
                this.setReturnPage("/cadastro.jsp");
            }
        } else if (finalidade.equalsIgnoreCase("Cadastrar-se")) {
            this.setReturnPage("/cadastro.jsp");
        }
    }

}
