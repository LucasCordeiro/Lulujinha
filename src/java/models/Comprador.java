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
public class Comprador{
    private String nome;
    private String email;
    private String senha;     
    private List<Avaliacao> avaliacoes;
    private List<Compra> compras;
    private Endereco endereco;

    public Comprador( String nome, String email, Endereco endereco, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    
    public void addAvaliacao(Avaliacao avaliacao){
        if(this.avaliacoes == null)
            this.avaliacoes = new ArrayList<Avaliacao>();
        
        this.avaliacoes.add(avaliacao);
        avaliacao.setComprador(this);
    }
    
    public void addCompra(Compra compra){
        if(this.compras == null)
            this.compras = new ArrayList<Compra>();
        
        this.compras.add(compra);
        compra.setComprador(this);
    }
    public Comprador() {
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
