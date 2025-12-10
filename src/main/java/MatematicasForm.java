import javax.swing.*;
import java.awt.*;  // ← Agrega este import también
import java.util.function.Consumer;

public class MatematicasForm {
    private JPanel mainPanel;
    private JButton testButton;

    private Workshop workshop;
    private Consumer<String> resultadoCallback;

    public MatematicasForm(Workshop workshop, Consumer<String> resultadoCallback) {
        this.workshop = workshop;
        this.resultadoCallback = resultadoCallback;

        testButton.setText("Probar Suma");
        testButton.addActionListener(e -> {
            int resultado = workshop.sumarDosNumeros(5, 3);
            resultadoCallback.accept("5 + 3 = " + resultado);
        });
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}