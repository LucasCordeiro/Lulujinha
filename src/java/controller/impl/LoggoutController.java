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
import models.Produto;
import persistence.ProdutoDAO;

/**
 *
 * @author LucasAugustoCordeiro
 */
public class LoggoutController extends AbstractController{

    @Override
    public void execute() {
        
        HttpServletRequest request = this.getRequest();
        request.getSession().invalidate();
        
        ProdutoDAO prod = new ProdutoDAO();
        List<Produto> lista_produtos = new <Produto>ArrayList();
        lista_produtos = prod.listar();
        
        request.setAttribute("lista_produtos", lista_produtos);
        
        this.setReturnPage("/index.jsp");
    }
    
    
}
