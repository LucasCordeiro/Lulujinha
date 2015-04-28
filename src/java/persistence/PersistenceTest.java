///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package persistence;
//
//import java.io.Serializable;
//import models.Comprador;
//import models.Endereco;
//
///**
// *
// * @author RodrigoSoldi
// */
//public class PersistenceTest {
//    public static void main(String[] args) {
//        Comprador comprador = new Comprador();
//        comprador.setNome("Rodrigo Soldi Lopes");
//        comprador.setEmail("rodrigosoldi@icloud.com");
//        comprador.setSenha("lulugay");
//        
//        Endereco endereco = new Endereco();
//        endereco.setCep("01221020");
//        endereco.setComplemento("Apto 112");
//        endereco.setNome("Rua Dr. Cesário Motta Jr.");
//        endereco.setNumero("526");
//        
//        comprador.setEndereco(endereco);
//        
//        PersistenceInterface iPersistence = new PersistenceInterfaceImpl();
//        
//        //Teste salvando entidade
//        iPersistence.save(comprador);
//        
//        //Teste recuperando entidade;
//        iPersistence.getById(Endereco.class, 1L);
//    }
//}
