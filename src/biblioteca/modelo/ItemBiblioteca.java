package biblioteca.modelo;

// Classe base para itens (livro, revista). Mantém título e estado.
public abstract class ItemBiblioteca {
    protected String titulo;
    protected boolean disponivel = true;

    public ItemBiblioteca(String titulo) { this.titulo = titulo; }

    public String getTitulo() { return titulo; }
    public boolean isDisponivel() { return disponivel; }

    // Empresta se disponível.
    public boolean emprestar() {
        if (!disponivel) return false;
        disponivel = false;
        return true;
    }

    // Devolve se estava emprestado.
    public boolean devolver() {
        if (disponivel) return false;
        disponivel = true;
        return true;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo() + ": " + titulo + (disponivel ? " [Disponível]" : " [Emprestado]");
    }
}
