import DAO.AlunoDAO;
import entidade.Aluno;

public class App {
    public static void main(String[] args) throws Exception {
        Aluno aluno = new Aluno(1, "Joacas");

        new AlunoDAO().cadastrarAluno(aluno);
    }
}
