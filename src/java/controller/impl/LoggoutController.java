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

/**
 *
 * @author LucasAugustoCordeiro
 */
public class LoggoutController extends AbstractController{

    @Override
    public void execute() {
        
        HttpServletRequest request = this.getRequest();
        request.getSession().invalidate();
        
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
    }
    
    
}
