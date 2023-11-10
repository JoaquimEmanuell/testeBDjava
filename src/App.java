import DAO.DisciplinaDAO;
import DAO.ProfessorDAO;
import entidade.Disciplina;
import entidade.Professor;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println(">>>> Sistema Universitário <<<<");
        while (true) {
            System.out.println("""
                    [1] Cadastrar professor
                    [2] Editar professor
                    [3] Pesquisar professor
                    [4] Excluir professor
                    [5] Cadastrar disciplina
                    [6] Editar disciplina
                    [7] Pesquisar disciplina
                    [8] Excluir disciplina
                    [9] sair
                    
                    """);
            int opcao = input.nextInt();
            switch (opcao) {
                case 1: {
                    Professor professor = new Professor();
                    ProfessorDAO professorDAO = new ProfessorDAO();
                    System.out.println("Digite a matrícula do professor: ");
                    int mat = input.nextInt();

                    System.out.println("Digite o nome do professor: ");
                    String nome = input.next();

                    professor.setMatricula(mat);
                    professor.setNome(nome);

                    professorDAO.cadastrarProfessor(professor);
                    break;
                }
                case 2: {
                    Professor professor= new Professor();
                    ProfessorDAO professorDAO = new ProfessorDAO();
                    System.out.println("Digite a matricula do professor que deseja alterar: ");
                    int mat=input.nextInt();

                    System.out.println(professor.getNome());

                    System.out.println("Digite o nome para alteração: ");
                    String nome= input.next();

                    professor.setMatricula(mat);
                    professor.setNome(nome);

                    professorDAO.editarProfessor(professor);
                    //

                    break;
                }
                case 4:{
                    ProfessorDAO professorDAO = new ProfessorDAO();
                    System.out.println("Digite a matrícula do professor que deseja excluir: ");
                    int mat = input.nextInt();

                    professorDAO.excluir(mat);
                }
                case 5:{
                    Disciplina disciplina = new Disciplina();
                    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                    System.out.println("Digite o código da disciplina: ");
                    int codigo = input.nextInt();
                    System.out.println("Digite o nome da disciplina: ");
                    String nome = input.next();
                    System.out.println("Digite a matricula do professor responsavel pela disciplina: ");
                    int idProfessor = input.nextInt();

                    disciplina.setNome(nome);
                    disciplina.setCodigo(codigo);
                    disciplina.setIdProfessor(idProfessor);

                    disciplinaDAO.cadastrarDisciplina(disciplina);
                }
                case 6:{
                    Disciplina disciplina = new Disciplina();
                    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                    System.out.println("Digite o codigo da disciplina que deseja alterar: ");
                    int codigo = input.nextInt();
                    System.out.println("Digite o nome para alteração: ");
                    String nome = input.next();
                    System.out.println("Digite a matrícula do professor resp. pela disciplina para alteração: ");
                    int idProfessor = input.nextInt();

                    disciplina.setCodigo(codigo);
                    disciplina.setNome(nome);
                    disciplina.setIdProfessor(idProfessor);

                    disciplinaDAO.editarDisciplina(disciplina);
                }
                case 8:{
                    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                    System.out.println("Digite o código da disciplina que deseja excluir: ");
                    int codigo = input.nextInt();

                    disciplinaDAO.excluirDisciplina(codigo);
                }
                case 9:{
                    System.out.println("Saindo do sistema");
                    System.exit(1);
                    break;
                }
                default: {
                    System.out.println("--- Digite uma opção válida! ---");
                }

            }
        }

    }
}
