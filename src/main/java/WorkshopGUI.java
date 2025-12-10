import javax.swing.*;

public class WorkshopGUI {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextArea textArea1;

    public WorkshopGUI() {
        textArea1.setEditable(false);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.setRows(8);
        textArea1.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
    }

    public void mostrarResultado(String resultado) {
        textArea1.append(resultado + "\n");
        textArea1.append("----------------------------------------\n");

        textArea1.setCaretPosition(textArea1.getDocument().getLength());
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Workshop - POO");
            frame.setContentPane(new WorkshopGUI().panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
