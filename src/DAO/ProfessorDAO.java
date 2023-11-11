package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import entidade.Professor;

public class ProfessorDAO {
    ResultSet rs;

    public void cadastrarProfessor(Professor professor) throws ClassNotFoundException {
        String sql = "INSERT INTO professor(nome) VALUES (?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
           // ps.setInt(1, professor.getMatricula());
            ps.setString(1, professor.getNome());
            ps.execute();
            ps.close();

            System.out.println("Professor cadastrado com sucesso!\n\n");

        }
        catch (SQLException e) {
            e.printStackTrace();
            //
        }
    }
    public void pesquisar(String nome ){
        String sql= "SELECT * FROM professor WHERE nome LIKE ?";
        ArrayList<Professor> listaProf= new ArrayList<>();
        try{
            PreparedStatement pstmt = null;
            pstmt = Conexao.getConexao().prepareStatement(sql);
            pstmt.setString(1,"%"+nome+"%");
            rs= pstmt.executeQuery();

            Professor professor= new Professor();
            while (rs.next()){
                professor.setMatricula(rs.getInt("matricula"));
                professor.setNome(rs.getString("nome"));

                listaProf.add(professor);
                System.out.println("--------------------------------------");
                System.out.println("MATRICULA: "+professor.getMatricula());
                System.out.println("NOME: "+professor.getNome());

            }




            pstmt.close();
        }
        catch (SQLException | ClassNotFoundException e) {
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
            System.out.println("Professor editado com sucesso!\n\n");

        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void exibir(Professor professor, int mat){
        String sql= "SELECT * FROM professor WHERE matricula=?";
        try{
            PreparedStatement pstmt = null;
            pstmt = Conexao.getConexao().prepareStatement(sql);
            pstmt.setInt(1,mat);
            rs= pstmt.executeQuery();

            professor.setMatricula(rs.getInt("matricula"));
            professor.setNome(rs.getString("nome"));

            System.out.println("Dados do professor:");
            System.out.println("MATRICULA: "+professor.getMatricula());
            System.out.println("NOME: "+professor.getNome());

            pstmt.close();

        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int matricula){
        String sql = "DELETE FROM professor WHERE matricula = ?";

        try{
            PreparedStatement ps = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, matricula);

            ps.execute();
            ps.close();

            System.out.println("Professor excluido com sucesso!\n\n");
        }
        catch (SQLException | ClassNotFoundException e){
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
