package biblioteca.modelo;

import java.time.Year; // usado para obter ano atual de forma simples

/**
 * Classe Revista representa uma revista dentro da biblioteca.
 * Como aluno de 4º período, deixei a classe simples mas já
 * com alguns atributos básicos e validações iniciais.
 */
public class Revista extends ItemBiblioteca {

    // Número da edição da revista (ex: 5, 12, etc.)
    private int edicao;
    // Ano em que a revista foi publicada
    private int anoPublicacao;

    /**
     * Construtor básico mantendo compatibilidade com código antigo
     * que só passava o título. Define valores padrão simples.
     */
    public Revista(String titulo) {
        super(titulo);
        this.edicao = 1; // padrão inicial
        this.anoPublicacao = Year.now().getValue(); // ano corrente
    }

    /**
     * Construtor completo para criar uma revista com edição e ano.
     * Faz validações simples para evitar dados sem sentido.
     */
    public Revista(String titulo, int edicao, int anoPublicacao) {
        super(titulo);
        if (edicao <= 0) {
            throw new IllegalArgumentException("Edicao deve ser positiva.");
        }
        if (anoPublicacao <= 0) {
            throw new IllegalArgumentException("Ano de publicacao invalido.");
        }
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String getTipo() {
        return "Revista";
    }

    public int getEdicao() { return edicao; }
    public int getAnoPublicacao() { return anoPublicacao; }

    /**
     * Representação textual simples para depuração ou listagens.
     */
    @Override
    public String toString() {
        return getTipo() + ": " + getTitulo() +
                " (Edicao " + edicao + ", Ano " + anoPublicacao + ")";
    }
}
