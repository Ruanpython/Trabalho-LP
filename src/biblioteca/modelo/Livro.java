package biblioteca.modelo;

public class Livro extends ItemBiblioteca {
    private final String autor;
    private int paginas; // pode ser 0 se desconhecido

    public Livro(String titulo, String autor) { this(titulo, autor, 0); }
    public Livro(String titulo, String autor, int paginas) {
        super(titulo);
        this.autor = autor;
        this.paginas = paginas < 0 ? 0 : paginas; // atribuição direta evita alerta
    }

    public String getAutor() { return autor; }
    public int getPaginas() { return paginas; }
    public void setPaginas(int paginas) { this.paginas = paginas < 0 ? 0 : paginas; }

    public String resumo() { return titulo + " - " + autor + (paginas>0?" ("+paginas+" págs)":""); }

    @Override public String getTipo() { return "Livro"; }

    @Override public String toString() { return super.toString() + " | Autor: " + autor + (paginas>0?" | Págs: "+paginas:" "); }
}
