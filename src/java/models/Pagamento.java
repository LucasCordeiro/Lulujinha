/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author RodrigoSoldi
 */
public class Pagamento{
    
    
    private Compra compra;
    
    
    
    public void geraBoleto(Compra c){}
    
    public void debitoConta(Compra c){}
    
    public void confirmaCompraPagSeguro(Compra c){}    
    

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Pagamento() {
    }

    
}
