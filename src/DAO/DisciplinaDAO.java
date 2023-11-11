package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import entidade.Disciplina;
import entidade.Professor;

public class DisciplinaDAO {
    ResultSet rs;
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

            System.out.println("Disciplina cadastrada com sucesso!\n\n");

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void pesquisar(String nome ){
        String sql= "SELECT * FROM disciplina WHERE nome LIKE ?";
        ArrayList<Disciplina> listaDisc= new ArrayList<>();
        try{
            PreparedStatement pstmt = null;
            pstmt = Conexao.getConexao().prepareStatement(sql);
            pstmt.setString(1,"%"+nome+"%");
            rs= pstmt.executeQuery();

            Disciplina disciplina = new Disciplina();
            while (rs.next()){
                disciplina.setCodigo(rs.getInt("codigo"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setIdProfessor(rs.getInt("idProfessor"));

                listaDisc.add(disciplina);
                System.out.println("--------------------------------------");
                System.out.println("CODIGO: "+disciplina.getCodigo());
                System.out.println("NOME: "+disciplina.getNome());
                System.out.println("PROFESSOR: "+disciplina.getIdProfessor());

            }
            pstmt.close();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void exibir(int mat){
        String sql= "SELECT * FROM disciplina WHERE codigo=?";
        try{
            PreparedStatement pstmt = null;
            pstmt = Conexao.getConexao().prepareStatement(sql);
            pstmt.setInt(1,mat);
            rs= pstmt.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getInt("codigo"));
                System.out.println(rs.getString("nome"));
                System.out.println(rs.getInt("idProfessor"));
            }

            pstmt.close();
        }
        catch (SQLException | ClassNotFoundException e) {
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
            System.out.println("Disciplina editado com sucesso!\n\n");

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
            System.out.println("Disciplina excluido com sucesso!\n\n");

        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
