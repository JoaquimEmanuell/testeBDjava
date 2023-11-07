package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entidade.Usuario;

public class UsuarioDAO {
    public void cadastrarUsuario(Usuario usuario) throws ClassNotFoundException {
        String sql = "INSERT INTO usuario (nome, senha) VALUES (?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*public void deletarTabela() {
        String sql = "DROP TABLE usuario";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.execute();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
