package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:sqlite:src\\conexao\\testebd.db";

    private static Connection conn;

    public static Connection getConexao() throws ClassNotFoundException {
        try {
            if (conn == null) {
                //Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection(url);
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
