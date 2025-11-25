package biblioteca.excecoes;

public class LivroIndisponivelException extends Exception {
    public LivroIndisponivelException() { super("Operação inválida sobre item"); }
    public LivroIndisponivelException(String msg) { super(msg); }
}
