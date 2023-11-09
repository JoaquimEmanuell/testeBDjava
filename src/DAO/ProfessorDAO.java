import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.Conexao;
import entidade.Professor;

public class ProfessorDAO {
    public void cadastrarProfessor(Professor professor) {
        String sql = "INSERT INTO professor VALUES (?, ?)";

        PreparedStatement ps = null;

        try {
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
}
