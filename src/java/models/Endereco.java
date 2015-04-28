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
public class Endereco  {
    private String nome;
    private String numero;
    private String complemento;
    private String cep;
    

    public Endereco() {
    }

    public Endereco(String nome, String numero, String complemento, String cep) {
        this.nome = nome;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }


    
}
