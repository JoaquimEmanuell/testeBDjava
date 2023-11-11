package entidade;

public class Professor {
    private int matricula;
    private String nome;

    /*public Professor(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }*/
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
