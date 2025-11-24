package biblioteca.repositorio;

import biblioteca.excecoes.*;
import biblioteca.modelo.*;
import java.util.*;

public class BibliotecaRepositorio {
    private final List<ItemBiblioteca> itens = new ArrayList<>();

    public void adicionarItem(ItemBiblioteca item) {
        itens.add(item);
    }

    public void emprestarItem(String titulo) throws LivroIndisponivelException {
        for (ItemBiblioteca item : itens) {
            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                if (!item.isDisponivel())
                    throw new LivroIndisponivelException("O item '" + titulo + "' não está disponível.");
                item.setDisponivel(false);
                return;
            }
        }
        throw new LivroIndisponivelException("Item '" + titulo + "' não encontrado.");
    }

    public List<ItemBiblioteca> listarItens() {
        return itens;
    }
}
