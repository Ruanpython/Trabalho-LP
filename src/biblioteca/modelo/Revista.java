package biblioteca.modelo;

public class Revista extends ItemBiblioteca {
    private int edicao;
    private int ano; // pode ser 0 se desconhecido
    private String palavraChave; // tag simples

    public Revista(String titulo) { this(titulo,1,0,null); }
    public Revista(String titulo, int edicao, int ano, String palavraChave) {
        super(titulo);
        this.edicao = edicao <=0 ? 1 : edicao;
        this.ano = ano <0 ? 0 : ano;
        this.palavraChave = palavraChave;
    }

    public int getEdicao() { return edicao; }
    public int getAno() { return ano; }
    public String getPalavraChave() { return palavraChave; }
    public void setEdicao(int edicao) { this.edicao = edicao <=0 ? 1 : edicao; }
    public void setAno(int ano) { this.ano = ano <0 ? 0 : ano; }
    public void setPalavraChave(String palavraChave) { this.palavraChave = palavraChave; }

    @Override public String getTipo() { return "Revista"; }

    @Override public String toString() {
        return super.toString() + " | Edição: " + edicao + (ano>0?" | Ano: "+ano:" ") + (palavraChave!=null?" | Tag: "+palavraChave:" ");
    }
}
