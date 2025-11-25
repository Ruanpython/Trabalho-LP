
package biblioteca;

import biblioteca.ui.TelaPrincipal;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            @SuppressWarnings("unused")
            TelaPrincipal frame = new TelaPrincipal();
   });
}
}