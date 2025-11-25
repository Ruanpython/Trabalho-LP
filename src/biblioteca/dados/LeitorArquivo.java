package biblioteca.dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo {
    public static boolean arquivoExiste(String caminho) { return new File(caminho).exists(); }

    public static List<String> lerLinhas(String caminho) {
        List<String> linhas = new ArrayList<>();
        if (!arquivoExiste(caminho)) return linhas;
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) linhas.add(linha);
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return linhas;
    }
}
