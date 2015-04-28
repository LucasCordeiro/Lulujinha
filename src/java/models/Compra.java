/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RodrigoSoldi
 */
public class Compra{
    private float valorTotal;
    
    private Produto produto;
    
    private Comprador comprador;
    
    private List<Pagamento> pagamentos;
    
    private List<Pedido> pedidos;
    
    public void addPagamento(Pagamento pagamento){
        if(this.pagamentos == null)
            this.pagamentos = new ArrayList<Pagamento>();
        
        this.pagamentos.add(pagamento);
        pagamento.setCompra(this);
    }
    
    public void addPedido(Pedido pedido){
        if(this.pedidos == null)
            this.pedidos = new ArrayList<Pedido>();
        
        this.pedidos.add(pedido);
        pedido.setCompra(this);
    }
    
    public void addProduto(Produto p){
        this.produto = p;
    }
    
    public void addCliente(Comprador c){
        this.comprador = c;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    
}
