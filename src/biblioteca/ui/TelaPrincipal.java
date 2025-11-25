package biblioteca.ui;

import biblioteca.modelo.*;
import biblioteca.repositorio.*;
import java.awt.*;
import javax.swing.*;

public class TelaPrincipal extends JFrame {
    private final BibliotecaRepositorio repo = new BibliotecaRepositorio();
    private final JTextArea areaTexto;

    public TelaPrincipal() {
        super("Sistema de Biblioteca");
        setLayout(new BorderLayout());

        areaTexto = new JTextArea(10, 40);
        JButton btnAdicionar = new JButton("Adicionar Livro");
        JButton btnListar = new JButton("Listar Itens");

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnListar);

        add(painelBotoes, BorderLayout.NORTH);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        btnAdicionar.addActionListener(e -> adicionarLivro());
        btnListar.addActionListener(e -> listarItens());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void adicionarLivro() {
        String titulo = JOptionPane.showInputDialog("Título do livro:");
        String autor = JOptionPane.showInputDialog("Autor do livro:");
        repo.adicionarItem(new Livro(titulo, autor));
    }

    private void listarItens() {
        StringBuilder sb = new StringBuilder();
        for (ItemBiblioteca item : repo.listarItens()) {
            sb.append(item.getTipo()).append(": ").append(item.getTitulo())
              .append(" - ").append(item.isDisponivel() ? "Disponível" : "Emprestado")
              .append("\n");
        }
        areaTexto.setText(sb.toString());
    }
}
