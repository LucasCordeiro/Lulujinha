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
public class Produto{
    
    private String scrImage;
    private String nome;
    private String preco;
    private String descricao;
    private String informacaoTecnica;
    
    private List<Avaliacao> avaliacoes;
    
    private List<Compra> compras;

    public Produto(String scrImage, String nome, String preco, String descricao, String informacaoTecnica) {
        this.scrImage = scrImage;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.informacaoTecnica = informacaoTecnica;
    }

    
    public void addAvaliacao(Avaliacao avaliacao){
        if(this.avaliacoes == null)
            this.avaliacoes = new ArrayList<Avaliacao>();
        
        this.avaliacoes.add(avaliacao);
        avaliacao.setProduto(this);
    }
    
    public void addCompra(Compra compra){
        if(this.compras == null)
            this.compras = new ArrayList<Compra>();
        
        this.compras.add(compra);
        compra.setProduto(this);
    }
    
    public Produto() {
    }

    public String getScrImage() {
        return scrImage;
    }

    public void setScrImage(String scrImage) {
        this.scrImage = scrImage;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInformacaoTecnica() {
        return informacaoTecnica;
    }

    public void setInformacaoTecnica(String informacaoTecnica) {
        this.informacaoTecnica = informacaoTecnica;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}
