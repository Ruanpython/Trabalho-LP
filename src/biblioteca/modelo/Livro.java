package biblioteca.modelo;

public class Livro extends ItemBiblioteca {
    private final String autor;

    public Livro(String titulo, String autor) {
        super(titulo);
        this.autor = autor;
    }

    public String getAutor() { return autor; }

    @Override
    public String getTipo() {
        return "Livro";
    }
}
