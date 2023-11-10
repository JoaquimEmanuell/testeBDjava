package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entidade.Disciplina;

public class DisciplinaDAO {
    public void cadastrarDisciplina(Disciplina disciplina) throws ClassNotFoundException {
        String sql = "INSERT INTO disciplina VALUES (?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, disciplina.getCodigo());
            ps.setString(2, disciplina.getNome());
            ps.setInt(3, disciplina.getIdProfessor());

            ps.execute();
            ps.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarDisciplina(Disciplina disciplina){
        String sql= "UPDATE disciplina SET nome =? AND idProfessor=? WHERE codigo=?";

        System.out.println("nome: "+ disciplina.getNome());
        System.out.println("professor: " + disciplina.getIdProfessor());

        try{
            PreparedStatement pstmt = null;
            pstmt = Conexao.getConexao().prepareStatement(sql);

            pstmt.setString(1, disciplina.getNome());
            pstmt.setInt(2, disciplina.getIdProfessor());
            pstmt.setInt(3, disciplina.getCodigo());

            pstmt.execute();
            pstmt.close();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void excluirDisciplina(int codigo){
        String sql = "DELETE FROM disciplina WHERE codigo = ?";

        try{
            PreparedStatement ps = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, codigo);

            ps.execute();
            ps.close();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
