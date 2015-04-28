/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author 1146322
 */
final class Conexao {

    private static Conexao conexao;
    private static ResourceBundle bundle;
    
    private Conexao() {
        bundle = ResourceBundle.getBundle("Util.configuracao");
    }

    public static synchronized Conexao getInstance() {
        if (conexao == null) {
            conexao = new Conexao();
        }
        return conexao;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(bundle.getString("driver"));
        return DriverManager.getConnection(bundle.getString("url"), bundle.getString("usuario"), bundle.getString("senha"));
    }
}
