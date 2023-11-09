package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entidade.Professor;

public class ProfessorDAO {
    public void cadastrarProfessor(Professor professor) throws ClassNotFoundException {
        String sql = "INSERT INTO professor VALUES (?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, professor.getMatricula());
            ps.setString(2, professor.getNome());
            ps.execute();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editarProfessor(Professor professor){
        String sql= "UPDATE professor SET nome =? WHERE matricula=?";

        System.out.println("nome: "+ professor.getNome());
        try{
            PreparedStatement pstmt = null;
            pstmt = Conexao.getConexao().prepareStatement(sql);

            pstmt.setString(1, professor.getNome());
            pstmt.setInt(2, professor.getMatricula());

            pstmt.execute();
            pstmt.close();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void exibir(Professor professor){
        String sql= "DELETE professor WHERE matricula=?";

        try{
            PreparedStatement pstmt = null;
            pstmt = Conexao.getConexao().prepareStatement(sql);

            pstmt.execute();
            pstmt.close();
        }
        catch (SQLException | ClassNotFoundException e) {
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
