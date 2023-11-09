package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entidade.Aluno;

public class AlunoDAO {
    public void cadastrarAluno(Aluno aluno) throws ClassNotFoundException {
        String sql = "INSERT INTO aluno VALUES (?, ?)"; 

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, aluno.getMatricula());
            ps.setString(2, aluno.getNome());
            ps.execute();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editarAluno(Aluno aluno){
        String sql= "UPDATE aluno SET nome =? WHERE matricula=?";

        System.out.println("nome: "+ aluno.getNome());
        try{
            PreparedStatement pstmt = null;
            pstmt = Conexao.getConexao().prepareStatement(sql);

            pstmt.setString(1, aluno.getNome());
            pstmt.setInt(2, aluno.getMatricula());

            pstmt.execute();
            pstmt.close();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void exibir(Aluno aluno){
        String sql= "DELETE aluno WHERE matricula=?";

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
