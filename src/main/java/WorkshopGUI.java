import javax.swing.*;
import java.awt.*;

public class WorkshopGUI extends JFrame {
    // === COMPONENTES DEL DISEÑADOR ===
    private JPanel panel1;
    private JPanel panelNavegacion;
    private JButton btnMatematicas;
    private JButton btnArreglos;
    private JButton btnCadenas;
    private JButton btnJuegos;
    private JButton btnConversiones;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private JTabbedPane tabbedPane;
    private JPanel panelMatematicas;
    private JPanel panelArreglos;
    private JPanel panelCadenas;
    private JPanel panelJuegos;
    private JPanel panelConversiones;
    private JPanel contenidoMatematicas;
    private JPanel panelCentralMat;

    // === VARIABLES PARA MATEMÁTICAS ===
    private JTextField txtFactorial;
    private JButton btnCalcularFactorial;
    private JTextArea txtResultadoFactorial;
    private JTextField txtPrimo;
    private JButton btnVerificarPrimo;
    private JTextArea txtResultadoPrimo;
    private JTextField txtFibonacci;
    private JButton btnCalcularFibonacci;
    private JTextArea txtResultadoFibonacci;
    private JTextField txtRadioCirculo;
    private JButton btnCalcularAreaCirculo;
    private JTextArea txtResultadoAreaCirculo;
    private JTextField txtDiaZodiaco;
    private JTextField txtMesZodiaco;
    private JButton btnCalcularZodiaco;
    private JTextArea txtResultadoZodiaco;

    // === VARIABLES PARA CONVERSIONES ===
    private JPanel contenidoConversiones;
    private JTextField txtBinario;
    private JButton btnConvertirBinario;
    private JTextArea txtResultadoBinario;
    private JTextField txtHexadecimal;
    private JButton btnConvertirHexadecimal;
    private JTextArea txtResultadoHexadecimal;
    private JPanel contenidoCadenas;

    // === CONSTRUCTOR ===
    public WorkshopGUI() {
        // 1. Inicializar componentes del diseñador
        initComponents();

        // 2. CONECTAR LOS BOTONES
        conectarActionListeners();

        // 3. Configurar la ventana
        configurarVentana();
    }

    // === MÉTODO GENERADO POR EL DISEÑADOR ===
    private void initComponents() {
        // CÓDIGO GENERADO AUTOMÁTICAMENTE POR INTELLIJ
        // NO MODIFICAR MANUALMENTE
        // Este método inicializa todos los componentes que arrastraste
    }

    // === MÉTODO PARA CONECTAR LOS BOTONES ===
    private void conectarActionListeners() {
        // === BOTONES DE NAVEGACIÓN ===
        btnMatematicas.addActionListener((e) -> {
            System.out.println("Botón Matemáticas presionado");
            if (tabbedPane != null) {
                tabbedPane.setSelectedIndex(0);
            }
        });

        btnArreglos.addActionListener((e) -> {
            System.out.println("Botón Arreglos presionado");
            if (tabbedPane != null) {
                tabbedPane.setSelectedIndex(1);
            }
        });

        btnCadenas.addActionListener((e) -> {
            System.out.println("Botón Cadenas presionado");
            if (tabbedPane != null) {
                tabbedPane.setSelectedIndex(2);
            }
        });

        btnJuegos.addActionListener((e) -> {
            System.out.println("Botón Juegos presionado");
            if (tabbedPane != null) {
                tabbedPane.setSelectedIndex(3);
            }
        });

        btnConversiones.addActionListener((e) -> {
            System.out.println("Botón Conversiones presionado");
            if (tabbedPane != null) {
                tabbedPane.setSelectedIndex(4);
            }
        });

        btnLimpiar.addActionListener((e) -> {
            System.out.println("Botón Limpiar presionado");
            limpiarTodo();
        });

        btnSalir.addActionListener((e) -> {
            System.out.println("Botón Salir presionado");
            int respuesta = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro que desea salir del programa?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        // === PANEL MATEMÁTICAS ===
        // Factorial
        btnCalcularFactorial.addActionListener((e) -> {
            System.out.println("Botón Calcular Factorial presionado");

            try {
                String texto = txtFactorial.getText().trim();

                if (texto.isEmpty()) {
                    txtResultadoFactorial.setText("ERROR: Ingrese un número");
                    return;
                }

                int numero = Integer.parseInt(texto);

                if (numero < 0 || numero > 20) {
                    txtResultadoFactorial.setText("ERROR: El número debe estar entre 0 y 20");
                    return;
                }

                Workshop workshop = new Workshop();
                int resultado = workshop.factorial(numero);

                txtResultadoFactorial.setText("Factorial de " + numero + " = " + resultado);

            } catch (NumberFormatException ex) {
                txtResultadoFactorial.setText("ERROR: Ingrese un número válido (ej: 5)");
            } catch (Exception ex) {
                txtResultadoFactorial.setText("ERROR: " + ex.getMessage());
            }
        });

        // Número Primo
        btnVerificarPrimo.addActionListener((e) -> {
            System.out.println("Botón Verificar Primo presionado");

            try {
                String texto = txtPrimo.getText().trim();

                if (texto.isEmpty()) {
                    txtResultadoPrimo.setText("ERROR: Ingrese un número");
                    return;
                }

                int numero = Integer.parseInt(texto);

                if (numero < 0) {
                    txtResultadoPrimo.setText("ERROR: Ingrese un número positivo");
                    return;
                }

                Workshop workshop = new Workshop();
                boolean esPrimo = workshop.esPrimo(numero);

                if (esPrimo) {
                    txtResultadoPrimo.setText(numero + " ES un número primo");
                } else {
                    txtResultadoPrimo.setText(numero + " NO es un número primo");
                }

            } catch (NumberFormatException ex) {
                txtResultadoPrimo.setText("ERROR: Ingrese un número válido");
            } catch (Exception ex) {
                txtResultadoPrimo.setText("ERROR: " + ex.getMessage());
            }
        });

        // Fibonacci
        btnCalcularFibonacci.addActionListener((e) -> {
            System.out.println("Botón Calcular Fibonacci presionado");

            try {
                String texto = txtFibonacci.getText().trim();

                if (texto.isEmpty()) {
                    txtResultadoFibonacci.setText("ERROR: Ingrese un número");
                    return;
                }

                int n = Integer.parseInt(texto);

                if (n < 0) {
                    txtResultadoFibonacci.setText("ERROR: Ingrese un número positivo");
                    return;
                }

                if (n > 20) {
                    txtResultadoFibonacci.setText("ERROR: Máximo 20 términos");
                    return;
                }

                Workshop workshop = new Workshop();
                int[] serie = workshop.serieFibonacci(n);

                StringBuilder resultado = new StringBuilder();
                resultado.append("Serie de Fibonacci (").append(n).append(" términos):\n");

                for (int i = 0; i < serie.length; i++) {
                    resultado.append(serie[i]);
                    if (i < serie.length - 1) {
                        resultado.append(", ");
                    }
                    if ((i + 1) % 5 == 0) {
                        resultado.append("\n");
                    }
                }

                txtResultadoFibonacci.setText(resultado.toString());

            } catch (NumberFormatException ex) {
                txtResultadoFibonacci.setText("ERROR: Ingrese un número válido");
            } catch (Exception ex) {
                txtResultadoFibonacci.setText("ERROR: " + ex.getMessage());
            }
        });

        // Área Círculo
        btnCalcularAreaCirculo.addActionListener((e) -> {
            System.out.println("Botón Calcular Área Círculo presionado");

            try {
                String texto = txtRadioCirculo.getText().trim();

                if (texto.isEmpty()) {
                    txtResultadoAreaCirculo.setText("ERROR: Ingrese el radio");
                    return;
                }

                double radio = Double.parseDouble(texto);

                if (radio < 0) {
                    txtResultadoAreaCirculo.setText("ERROR: El radio no puede ser negativo");
                    return;
                }

                Workshop workshop = new Workshop();
                double area = workshop.areaCirculo(radio);

                txtResultadoAreaCirculo.setText(String.format("Área del círculo con radio %.2f = %.2f", radio, area));

            } catch (NumberFormatException ex) {
                txtResultadoAreaCirculo.setText("ERROR: Ingrese un número válido (ej: 5.5)");
            } catch (Exception ex) {
                txtResultadoAreaCirculo.setText("ERROR: " + ex.getMessage());
            }
        });

        // Signo Zodiacal
        btnCalcularZodiaco.addActionListener((e) -> {
            System.out.println("Botón Calcular Signo Zodiacal presionado");

            try {
                String textoDia = txtDiaZodiaco.getText().trim();
                String textoMes = txtMesZodiaco.getText().trim();

                if (textoDia.isEmpty() || textoMes.isEmpty()) {
                    txtResultadoZodiaco.setText("ERROR: Ingrese día y mes");
                    return;
                }

                int dia = Integer.parseInt(textoDia);
                int mes = Integer.parseInt(textoMes);

                if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {
                    txtResultadoZodiaco.setText("ERROR: Día (1-31) y Mes (1-12) inválidos");
                    return;
                }

                Workshop workshop = new Workshop();
                String signo = workshop.zoodiac(dia, mes);

                if (signo.equals("Invalid Date")) {
                    txtResultadoZodiaco.setText("ERROR: Fecha inválida (ej: 31 de febrero)");
                } else {
                    txtResultadoZodiaco.setText("Signo zodiacal: " + signo + "\nFecha: " + dia + "/" + mes);
                }

            } catch (NumberFormatException ex) {
                txtResultadoZodiaco.setText("ERROR: Ingrese números válidos");
            } catch (Exception ex) {
                txtResultadoZodiaco.setText("ERROR: " + ex.getMessage());
            }
        });

        // === PANEL CONVERSIONES ===
        // Convertir a Binario
        btnConvertirBinario.addActionListener((e) -> {
            System.out.println("Botón Convertir a Binario presionado");

            try {
                String texto = txtBinario.getText().trim();

                if (texto.isEmpty()) {
                    txtResultadoBinario.setText("ERROR: Ingrese un número");
                    return;
                }

                int numero = Integer.parseInt(texto);

                Workshop workshop = new Workshop();
                String binario = workshop.convertirABinario(numero);

                txtResultadoBinario.setText("Decimal: " + numero + "\nBinario: " + binario);

            } catch (NumberFormatException ex) {
                txtResultadoBinario.setText("ERROR: Ingrese un número válido");
            } catch (Exception ex) {
                txtResultadoBinario.setText("ERROR: " + ex.getMessage());
            }
        });

        // Convertir a Hexadecimal
        btnConvertirHexadecimal.addActionListener((e) -> {
            System.out.println("Botón Convertir a Hexadecimal presionado");

            try {
                String texto = txtHexadecimal.getText().trim();

                if (texto.isEmpty()) {
                    txtResultadoHexadecimal.setText("ERROR: Ingrese un número");
                    return;
                }

                int numero = Integer.parseInt(texto);

                Workshop workshop = new Workshop();
                String hex = workshop.convertirAHexadecimal(numero);

                txtResultadoHexadecimal.setText("Decimal: " + numero + "\nHexadecimal: " + hex);

            } catch (NumberFormatException ex) {
                txtResultadoHexadecimal.setText("ERROR: Ingrese un número válido");
            } catch (Exception ex) {
                txtResultadoHexadecimal.setText("ERROR: " + ex.getMessage());
            }
        });
    }

    // === MÉTODO PARA LIMPIAR TODO ===
    private void limpiarTodo() {
        // Limpiar panel Matemáticas
        if (txtFactorial != null) txtFactorial.setText("");
        if (txtResultadoFactorial != null) txtResultadoFactorial.setText("");
        if (txtPrimo != null) txtPrimo.setText("");
        if (txtResultadoPrimo != null) txtResultadoPrimo.setText("");
        if (txtFibonacci != null) txtFibonacci.setText("");
        if (txtResultadoFibonacci != null) txtResultadoFibonacci.setText("");
        if (txtRadioCirculo != null) txtRadioCirculo.setText("");
        if (txtResultadoAreaCirculo != null) txtResultadoAreaCirculo.setText("");
        if (txtDiaZodiaco != null) txtDiaZodiaco.setText("");
        if (txtMesZodiaco != null) txtMesZodiaco.setText("");
        if (txtResultadoZodiaco != null) txtResultadoZodiaco.setText("");

        // Limpiar panel Conversiones
        if (txtBinario != null) txtBinario.setText("");
        if (txtResultadoBinario != null) txtResultadoBinario.setText("");
        if (txtHexadecimal != null) txtHexadecimal.setText("");
        if (txtResultadoHexadecimal != null) txtResultadoHexadecimal.setText("");

        JOptionPane.showMessageDialog(this,
                "Todos los campos han sido limpiados",
                "Limpieza completada",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // === CONFIGURAR LA VENTANA ===
    private void configurarVentana() {
        setTitle("Taller de Programación Orientada a Objetos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);

        // Asegurar tamaño adecuado
        setPreferredSize(new Dimension(900, 600));
        pack();
        setLocationRelativeTo(null);

        // Hacer visible
        setVisible(true);
    }

    // === MÉTODO MAIN ===
    public static void main(String[] args) {
        // Ejecutar en el hilo de Swing
        SwingUtilities.invokeLater(() -> {
            new WorkshopGUI();
        });
    }
}