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
}
