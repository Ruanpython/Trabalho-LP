package biblioteca.modelo;

public class Aluno extends Pessoa {
    public Aluno(String nome, String matricula) { super(nome, matricula); }
    public Aluno(String nome, String matricula, String email) { super(nome, matricula, email); }
    @Override public String getTipo() { return "Aluno"; }
}
