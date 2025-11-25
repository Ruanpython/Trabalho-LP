package biblioteca.modelo;

public class Professor extends Pessoa {
    public Professor(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public String getTipo() {
        return "Professor";
    }
}
