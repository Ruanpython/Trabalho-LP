package biblioteca.modelo;

public class Revista extends ItemBiblioteca {
    public Revista(String titulo) {
        super(titulo);
    }

    @Override
    public String getTipo() {
        return "Revista";
    }
}
