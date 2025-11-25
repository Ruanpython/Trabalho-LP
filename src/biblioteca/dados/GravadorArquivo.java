package biblioteca.dados;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GravadorArquivo {
    public static boolean gravarLinhas(String caminho, List<String> linhas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao gravar arquivo: " + e.getMessage());
            return false;
        }
    }
}
