import DAO.AlunoDAO;
import entidade.Aluno;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println(">>>> Sistema Universitário <<<<");
        while (true) {
            System.out.println("""
                    [1] Cadastrar aluno
                    [2] Editar aluno
                    [3] Pesquisar aluno
                    [4] Excluir aluno
                    [5] sair
                    
                    """);
            int opcao = input.nextInt();
            switch (opcao) {
                case 1: {
                    //Aluno aluno = new Aluno(123, "susu");
                    //new AlunoDAO().cadastrarAluno(aluno);
                    break;
                }
                case 2: {
                    Aluno aluno= new Aluno();
                    System.out.println("Digite a matricula do aluno que deseja alterar: ");
                    int mat=input.nextInt();

                    System.out.println(aluno.getNome());

                    System.out.println("Digite o nome para alteração: ");
                    String nome= input.next();

                    aluno.setMatricula(mat);
                    aluno.setNome(nome);

                    AlunoDAO alunoDAO= new AlunoDAO();
                    alunoDAO.editarAluno(aluno);


                    break;
                }
                case 5:{
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
