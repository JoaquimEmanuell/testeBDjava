import DAO.DisciplinaDAO;
import DAO.ProfessorDAO;
import entidade.Disciplina;
import entidade.Professor;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n>>>> Sistema Universitário <<<<");
            System.out.println("""
                    [1] Menu professor
                    [2] Menu disciplina                              
                    """);
            int menu = input.nextInt();
            if (menu==1){
                System.out.println("\n>>>> MENU PROFESSOR <<<<");
                System.out.println("""
                    [1] Cadastrar professor
                    [2] Editar professor
                    [3] Pesquisar professor
                    [4] Excluir professor          
                    [5] sair
                    
                    """);
                int opcao= input.nextInt();
                switch (opcao) {
                case 1: {
                    Professor professor = new Professor();
                    ProfessorDAO professorDAO = new ProfessorDAO();

                    System.out.println("Digite o nome do professor: ");
                    String nome = input.next();

                    professor.setNome(nome);

                    professorDAO.cadastrarProfessor(professor);
                    break;
                }
                case 2: {
                    Professor professor= new Professor();
                    ProfessorDAO professorDAO = new ProfessorDAO();
                    System.out.println("Digite a matricula do professor que deseja alterar: ");
                    int mat=input.nextInt();

                    professorDAO.exibir(professor,mat);

                    System.out.println("Digite o nome para alteração: ");
                    String nome= input.next();

                    professor.setMatricula(mat);
                    professor.setNome(nome);

                    professorDAO.editarProfessor(professor);
                    //

                    break;
                }
                case 3:{
                    ProfessorDAO professorDAO = new ProfessorDAO();
                    System.out.println("Digite o nome do professor que deseja pesquisar: ");
                    String nome = input.next();

                    professorDAO.pesquisar(nome);
                    break;
                }
                    case 4: {
                        ProfessorDAO professorDAO = new ProfessorDAO();
                        System.out.println("Digite o código do professor que deseja excluir: ");
                        int codigo = input.nextInt();

                        professorDAO.excluir(codigo);
                        break;
                    }
                case 5:{
                    System.out.println("Saindo...\n\n");
                    break;
                }
                default: {
                    System.out.println("--- Digite uma opção válida! ---");
                }

            }
            }

            else if (menu==2) {
                System.out.println(">>>> MENU DISCIPLINA <<<<");
                System.out.println("""
                    [1] Cadastrar disciplina
                    [2] Editar disciplina
                    [3] Pesquisar disciplina        
                    [4] Excluir disciplina
                    [5] Sair
                    
                    """);
                int opcao= input.nextInt();
                switch (opcao) {

                    case 1: {
                        Disciplina disciplina = new Disciplina();
                        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
//                        System.out.println("Digite o código da disciplina: ");
//                        int codigo = input.nextInt();
                        System.out.println("Digite o nome da disciplina: ");
                        String nome = input.next();
                        System.out.println("Digite a matricula do professor responsavel pela disciplina: ");
                        int idProfessor = input.nextInt();

                        disciplina.setNome(nome);
                        //disciplina.setCodigo(codigo);
                        disciplina.setIdProfessor(idProfessor);

                        disciplinaDAO.cadastrarDisciplina(disciplina);
                        break;
                    }
                    case 2: {
                        Disciplina disciplina = new Disciplina();
                        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                        System.out.println("Digite o código da disciplina: ");
                        int codigo = input.nextInt();

                        disciplinaDAO.exibir(codigo);
                        System.out.println("Digite o nome da disciplina: ");
                        String nome = input.next();

                        System.out.println("Digite a matricula do professor responsavel pela disciplina: ");
                        int idProfessor = input.nextInt();

                        disciplina.setNome(nome);
                        disciplina.setCodigo(codigo);
                        disciplina.setIdProfessor(idProfessor);

                        disciplinaDAO.editarDisciplina(disciplina);
                        break;
                    }
                    case 3: {
                        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                        System.out.println("Digite o nome da disciplina que deseja pesquisar: ");
                        String nome = input.next();

                        disciplinaDAO.pesquisar(nome);
                        break;
                    }
                    case 4: {
                        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                        System.out.println("Digite o código da disciplina que deseja excluir: ");
                        int codigo = input.nextInt();

                        disciplinaDAO.excluirDisciplina(codigo);
                        break;
                    }
                    case 5: {
                        System.out.println("Saindo...\n\n");
                        break;
                    }
                    default: {
                        System.out.println("--- Digite uma opção válida! ---");
                    }
                }
            }
        }

    }
}
