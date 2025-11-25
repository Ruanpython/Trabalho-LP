package biblioteca.repositorio;

import biblioteca.excecoes.LivroIndisponivelException;
import biblioteca.modelo.ItemBiblioteca;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaRepositorio {
    private final List<ItemBiblioteca> itens = new ArrayList<>();

    public void adicionarItem(ItemBiblioteca item) { itens.add(item); }

    public ItemBiblioteca buscarPorTitulo(String titulo) {
        for (ItemBiblioteca i : itens) {
            if (i.getTitulo().equalsIgnoreCase(titulo)) return i;
        }
        return null;
    }

    public boolean emprestarItem(String titulo) throws LivroIndisponivelException {
        ItemBiblioteca item = buscarPorTitulo(titulo);
        if (item == null) throw new LivroIndisponivelException("Item não encontrado: " + titulo);
        if (!item.emprestar()) throw new LivroIndisponivelException("Item já emprestado: " + titulo);
        return true;
    }

    public boolean devolverItem(String titulo) throws LivroIndisponivelException {
        ItemBiblioteca item = buscarPorTitulo(titulo);
        if (item == null) throw new LivroIndisponivelException("Item não encontrado: " + titulo);
        if (!item.devolver()) throw new LivroIndisponivelException("Item já estava disponível: " + titulo);
        return true;
    }

    public List<ItemBiblioteca> listarItens() { return itens; }
}
