package biblioteca.ui;

import biblioteca.modelo.ItemBiblioteca;
import biblioteca.modelo.Livro;
import biblioteca.modelo.Revista;
import biblioteca.repositorio.BibliotecaRepositorio;
import java.awt.BorderLayout;
import javax.swing.*;

public class TelaPrincipal extends JFrame {
    private final BibliotecaRepositorio repo = new BibliotecaRepositorio();
    private final JTextArea areaTexto;

    public TelaPrincipal() {
        super("Biblioteca");
        setLayout(new BorderLayout());

        areaTexto = new JTextArea(12, 50);
        JButton btnAddLivro = new JButton("Add Livro");
        JButton btnAddRevista = new JButton("Add Revista");
        JButton btnListar = new JButton("Listar");
        JButton btnEmprestar = new JButton("Emprestar");
        JButton btnDevolver = new JButton("Devolver");

        JPanel top = new JPanel();
        top.add(btnAddLivro);
        top.add(btnAddRevista);
        top.add(btnListar);
        top.add(btnEmprestar);
        top.add(btnDevolver);
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        btnAddLivro.addActionListener(e -> adicionarLivro());
        btnAddRevista.addActionListener(e -> adicionarRevista());
        btnListar.addActionListener(e -> listar());
        btnEmprestar.addActionListener(e -> emprestar());
        btnDevolver.addActionListener(e -> devolver());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void adicionarLivro() {
        String titulo = JOptionPane.showInputDialog("Título livro");
        if (titulo == null || titulo.isBlank()) return;
        String autor = JOptionPane.showInputDialog("Autor");
        if (autor == null || autor.isBlank()) return;
        String paginasStr = JOptionPane.showInputDialog("Páginas (opcional)");
        int pags = 0;
        try { if (paginasStr != null && !paginasStr.isBlank()) pags = Integer.parseInt(paginasStr); } catch (NumberFormatException ignored) {}
        repo.adicionarItem(new Livro(titulo, autor, pags));
    }

    private void adicionarRevista() {
        String titulo = JOptionPane.showInputDialog("Título revista");
        if (titulo == null || titulo.isBlank()) return;
        String edicaoStr = JOptionPane.showInputDialog("Edição");
        String anoStr = JOptionPane.showInputDialog("Ano");
        String tag = JOptionPane.showInputDialog("Palavra-chave (opcional)");
        int ed = 1, ano = 0;
        try { if (edicaoStr != null && !edicaoStr.isBlank()) ed = Integer.parseInt(edicaoStr); } catch (NumberFormatException ignored) {}
        try { if (anoStr != null && !anoStr.isBlank()) ano = Integer.parseInt(anoStr); } catch (NumberFormatException ignored) {}
        repo.adicionarItem(new Revista(titulo, ed, ano, tag));
    }

    private void emprestar() {
        String titulo = JOptionPane.showInputDialog("Título para emprestar");
        if (titulo == null || titulo.isBlank()) return;
        try {
            repo.emprestarItem(titulo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void devolver() {
        String titulo = JOptionPane.showInputDialog("Título para devolver");
        if (titulo == null || titulo.isBlank()) return;
        try {
            repo.devolverItem(titulo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void listar() {
        StringBuilder sb = new StringBuilder();
        for (ItemBiblioteca i : repo.listarItens()) sb.append(i).append('\n');
        areaTexto.setText(sb.toString());
    }
}
