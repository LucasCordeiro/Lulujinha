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
        
        List lista_produtos = new ArrayList();
      
        Produto produto1 = new Produto("img/iPhone.jpg", "Capa iPhone", 10.00, "Capa de silicone para iPhone 6", "Silicone\nAltura: 15cm\nLargura: 10cm");
        Produto produto2 = new Produto("img/Mac.jpg", "Capa MacBook", 10.00, "Capa de plastico para MacBookPro", "Plastico\nAltura: 20cm\nLargura: 30cm");
        Produto produto3 = new Produto("img/iPad.jpg", "Capa iPad", 10.00, "Capa de plastico para iPad 4", "Plastico\nAltura: 20cm\nLargura: 25cm");
        Produto produto4 = new Produto("img/iPod.jpg", "Capa iPod", 10.00, "Capa de silicone para iPod", "Silicone\nAltura: 10cm\nLargura: 5cm");
        
        lista_produtos.add(produto1);
        lista_produtos.add(produto2);
        lista_produtos.add(produto3);
        lista_produtos.add(produto4);
        
        request.setAttribute("lista_produtos", lista_produtos);
        
        this.setReturnPage("/index.jsp");
        request.setAttribute("erroLogin", "Login ou senha inválidos");

        List<Comprador> listaComprador = new ArrayList();
        
        Endereco endereco = new Endereco("Dr. Renato Bueno Neto", "213", "", "05767-350");
        Endereco endereco1 = new Endereco("Dr. Renato Bueno Neto", "213", "Casa B", "05767-350");

        //
        //Deletar quando integrar com o banco
        Comprador comprador1 = new Comprador("Lucas", "lucas@eu.com", endereco, "lucas");
        Comprador comprador2 = new Comprador("Soldi", "soldi@eu.com", endereco1, "soldi");
        Comprador comprador3 = new Comprador("Hudson", "hudson@eu.com", endereco, "hudson");
        Comprador comprador4 = new Comprador("Renan", "renan@eu.com", endereco1, "renan");
        Comprador comprador5 = new Comprador("Trautven", "trautven@eu.com", endereco, "trautven");
        Comprador comprador6 = new Comprador("Pedro", "pedro@eu.com", endereco1, "pedro");
        
        listaComprador.add(comprador1);
        listaComprador.add(comprador2);
        listaComprador.add(comprador3);
        listaComprador.add(comprador4);
        listaComprador.add(comprador5);
        listaComprador.add(comprador6);
        
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
