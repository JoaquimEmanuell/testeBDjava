import DAO.ProfessorDAO;
import entidade.Professor;

public class App {
    public static void main(String[] args) throws Exception {
        Professor professor = new Professor(1, "Ismayle");
        new ProfessorDAO().cadastrarProfessor(professor);
    }
}
