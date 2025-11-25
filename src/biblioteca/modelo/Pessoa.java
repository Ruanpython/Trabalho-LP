package biblioteca.modelo;

// Pessoa da biblioteca (Aluno ou Professor). Email opcional.
public abstract class Pessoa {
    protected String nome;
    protected String matricula;
    protected String email; // pode ficar nulo

    public Pessoa(String nome, String matricula) { this(nome, matricula, null); }

    public Pessoa(String nome, String matricula, String email) {
        this.nome = nome;
        this.matricula = matricula;
        setEmail(email);
    }

    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public String getEmail() { return email; }

    public void setEmail(String email) {
        if (email == null || email.isBlank() || !email.contains("@")) {
            this.email = null; // simples
        } else {
            this.email = email;
        }
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo() + ": " + nome + " (Matricula: " + matricula + (email!=null?", Email: "+email:"") + ")";
    }
}
