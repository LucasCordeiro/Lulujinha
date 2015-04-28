/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Comprador;
import models.Endereco;

/**
 *
 * @author 1146322
 */
public class CompradorDAO implements GenericoDAO<Comprador> {

    @Override
    public void inserir(Comprador e) {
        Connection connection;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO LULU.COMPRADOR(NOME,EMAIL,SENHA,NOME_END,NUMERO,COMPLEMENTO,CEP)"
                    + " VALUES (?,?,?,?,?,?,?)");
            statement.setString(1, e.getNome().toUpperCase());
            statement.setString(2, e.getEmail());
            statement.setString(3, e.getSenha());
            statement.setString(4, e.getEndereco().getNome());
            statement.setString(5, e.getEndereco().getNumero());
            statement.setString(6, e.getEndereco().getComplemento());
            statement.setString(7, e.getEndereco().getCep());
            
            statement.execute();
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void alterar(Comprador e) {

    }

    @Override
    public List<Comprador> listar() {
        List<Comprador> clientes = new ArrayList<>();
        try {
            Connection connection = Conexao.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT C.NOME, C.EMAIL, C.SENHA, C.NOME_END,"
                    +"C.NUMERO, C.COMPLEMENTO, C.CEP FROM LULU.COMPRADOR AS C");
            while (result.next()) {
                Comprador cliente = new Comprador();
                cliente.setNome(result.getString("NOME"));
                cliente.setEmail(result.getString("EMAIL"));
                cliente.setSenha(result.getString("SENHA"));
                
                Endereco endereco = new Endereco();
                endereco.setNome(result.getString("NOME_END"));
                endereco.setNumero(result.getString("NUMERO"));
                endereco.setComplemento(result.getString("COMPLEMENTO"));
                endereco.setCep(result.getString("CEP"));
                
                cliente.setEndereco(endereco);
                clientes.add(cliente);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    public Comprador buscaPorID(int id) {
        return new Comprador();
    }
    
    public Comprador buscaPorEmailESenha(String email,String senha) {
        Comprador cliente = new Comprador();
        Connection connection;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT C.NOME, C.EMAIL C.SENHA, "
                    + "C.NOME_END C.NUMERO,C.COMPLEMENTO,C.CEP "
                    + "FROM LULU.COMPRADOR AS C"
                    + "WHERE C.EMAIL = ? AND C.SENHA = ?");
            statement.setString(1, email);
            statement.setString(2, senha);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                cliente.setNome(result.getString("NOME"));
                cliente.setEmail(result.getString("EMAIL"));
                cliente.setSenha(result.getString("SENHA"));
                
                Endereco endereco = new Endereco();
                endereco.setNome(result.getString("NOME_END"));
                endereco.setNumero(result.getString("NUMERO"));
                endereco.setComplemento(result.getString("COMPLEMENTO"));

                cliente.setEndereco(endereco);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;
    }

    @Override
    public void remover(Comprador e) {

    }
}
