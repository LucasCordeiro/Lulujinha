/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.impl;

import controller.AbstractController;

/**
 *
 * @author LucasAugustoCordeiro
 */
public class PayPalController extends AbstractController {

    @Override
    public void execute() {

        this.setReturnPage("/index.jsp");
    }

}
