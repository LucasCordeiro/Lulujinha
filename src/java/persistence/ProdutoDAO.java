/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Produto;

/**
 *
 * @author 41328647
 */
@WebServlet(name = "ProdutoDAO", urlPatterns = {"/ProdutoDAO"})
public class ProdutoDAO implements GenericoDAO<Produto> {

    @Override
    public void inserir(Produto p) {
        Connection connection;
        try {
            connection = Conexao.getInstance().getConnection();
    //            String scrImage, String nome, double preco, String descricao, String informacaoTecnica
            PreparedStatement statement = connection.prepareStatement("INSERT INTO LULU.PRODUTO(SCRIMAGE,NOME,PRECO,DESCRICAO,INFORMACAOTECNICA)"
                    + " VALUES (?,?,?,?)");
            statement.setString(1, p.getScrImage());
            statement.setString(2, p.getPreco());
            statement.setString(3, p.getDescricao());
            statement.setString(4, p.getInformacaoTecnica());
            statement.execute();
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void alterar(Produto p) {

    }
    

    @Override
    public void remover(Produto p) {

    }

    @Override
    public List listar() {
        List<Produto> lista_produtos = new ArrayList<>();
        try {
            Connection connection = Conexao.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet result;
            result = statement.executeQuery("SELECT P.SCRIMAGE, P.NOME, P.PRECO, P.DESCRICAO, P.INFORMACAOTECNICA FROM LULU.PRODUTO AS P");
            try {
                while (result.next()) {
                    Produto produto = new Produto();
                    produto.setScrImage(result.getString("SCRIMAGE"));
                    produto.setNome(result.getString("NOME"));
                    produto.setPreco(result.getString("PRECO"));
                    produto.setDescricao(result.getString("DESCRICAO"));
                    produto.setInformacaoTecnica(result.getString("INFORMACAOTECNICA"));
                    
                    lista_produtos.add(produto);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_produtos;
    }

    public List listarBusca(String nomeHotel, String cidade) {
        List<Produto> lista_produtos = new ArrayList<>();
//        try {
//            Connection connection = Conexao.getInstance().getConnection();
//            PreparedStatement statement = connection.prepareStatement("SELECT H.ID_HOTEL AS ID,H.NOME AS NOME,H.ESTRELAS AS ESTRELAS, "
//                    + "E.ID_ENDERECO,E.LOGRADOURO AS TIPO,E.NOME AS LOGRADOURO, E.CEP AS CEP, E.BAIRRO AS BAIRRO, "
//                    + " E.COMPLEMENTO AS COMPLEMENTO, E.CIDADE AS CIDADE "
//                    + "FROM HOTEL.HOTEL AS H "
//                    + "INNER JOIN HOTEL.ENDERECO AS E "
//                    + "ON H.ID_ENDERECO = E.ID_ENDERECO "
//                    + "WHERE H.NOME = ? AND "
//                    + "E.CIDADE = ? ");
//            statement.setString(1, nomeHotel.toUpperCase());
//            statement.setString(2, cidade.toUpperCase());
//            ResultSet result;
//            result = statement.executeQuery();
//
//            try {
//                while (result.next()) {
//                    Hotel hotel = new Hotel();
//                    hotel.setCodigo(result.getInt("ID"));
//                    hotel.setNome(result.getString("NOME"));
//                    hotel.setEstrelas(result.getInt("ESTRELAS"));
//
//                    Endereco endereco = new Endereco();
//                    endereco.setCodigo(result.getInt("ID_ENDERECO"));
//                    endereco.setLogradouro(result.getString("TIPO"));
//                    endereco.setNome(result.getString("LOGRADOURO"));
//                    endereco.setBairro(result.getString("BAIRRO"));
//                    endereco.setCep(result.getString("CEP"));
//                    endereco.setComplemento(result.getString("COMPLEMENTO"));
//                    endereco.setCidade(result.getString("CIDADE"));
//
//                    hotel.setEndereco(endereco);
//                    hoteis.add(hotel);
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(ProdutolDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(ProdutolDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return lista_produtos;
    }
     public List buscaHoteisVagos() {
        List<Produto> lista_produtos = new ArrayList<Produto>();
//        try {
//            Connection connection = Conexao.getInstance().getConnection();
//            PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT H.NOME,H.ESTRELAS,H.EMAIL,H.TELEFONE, " +
//            "E.ID_ENDERECO,E.LOGRADOURO AS TIPO,E.NOME AS LOGRADOURO, E.CEP AS CEP, E.BAIRRO AS BAIRRO,  " +
//            "E.COMPLEMENTO AS COMPLEMENTO, E.CIDADE AS CIDADE " +
//            "FROM HOTEL.HOTEL H " +
//            "INNER JOIN HOTEL.ENDERECO E " +
//            "ON H.ID_ENDERECO = E.ID_ENDERECO " +
//            "INNER JOIN HOTEL.QUARTO Q " +
//            "ON Q.ID_HOTEL = H.ID_HOTEL " +
//            "WHERE Q.DISPONIVEL = TRUE; ");            
//            ResultSet result;
//            result = statement.executeQuery();
//            try {
//                while (result.next()) {
//                    Hotel hotel = new Hotel();
//                    hotel.setCodigo(result.getInt("ID"));
//                    hotel.setNome(result.getString("NOME"));
//                    hotel.setEstrelas(result.getInt("ESTRELAS"));
//                    hotel.setEmail(result.getString("EMAIL"));
//                    hotel.setTelefone(result.getString("TELEFONE"));
//
//                    Endereco endereco = new Endereco();
//                    endereco.setCodigo(result.getInt("ID_ENDERECO"));
//                    endereco.setLogradouro(result.getString("TIPO"));
//                    endereco.setNome(result.getString("LOGRADOURO"));
//                    endereco.setBairro(result.getString("BAIRRO"));
//                    endereco.setCep(result.getString("CEP"));
//                    endereco.setComplemento(result.getString("COMPLEMENTO"));
//                    endereco.setCidade(result.getString("CIDADE"));
//
//                    hotel.setEndereco(endereco);
//                    hoteis.add(hotel);
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(ProdutolDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(ProdutolDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return lista_produtos;
    }
public Produto buscaNome(String nome)
    {
        Produto produto  = new Produto();
        Connection connection;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT P.SCRIMAGE, P.NOME, P.PRECO, P.DESCRICAO, P.INFORMACAOTECNICA"
                    + " FROM LULU.PRODUTO AS P"
                    + " WHERE NOME = ?");
           statement.setString(1,nome);
           ResultSet result = statement.executeQuery();
           while (result.next())
           {
           produto.setScrImage(statement.getResultSet().getString("SCRIMAGEM"));
           produto.setNome(nome);
           produto.setPreco(statement.getResultSet().getString("PRECO"));           
           produto.setDescricao(statement.getResultSet().getString("DESCRICAO"));
           produto.setInformacaoTecnica(statement.getResultSet().getString("INFORMACAOTECNICA"));
           
           }
           connection.close();      
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return produto;
    }
}
