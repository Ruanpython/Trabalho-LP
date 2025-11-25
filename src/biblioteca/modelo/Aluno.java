package biblioteca.modelo;

public class Aluno extends Pessoa {
    public Aluno(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public String getTipo() {
        return "Aluno";
    }
}
