package biblioteca.excecoes;

public class UsuarioInvalidoException extends Exception {
    public UsuarioInvalidoException() { super("Usuário inválido"); }
    public UsuarioInvalidoException(String msg) { super(msg); }
}
