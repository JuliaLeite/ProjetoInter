import controller.CalculadorPON;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private JTextField potenciaTransmissaoTextField;
    private JTextField sensibilidadeRecepcaoTextField;
    private JTextField atenuacaoFibraTextField;
    private JTextField perdasPowerSplittersTextField;
    private JTextField quantidadeConectoresTextField;
    private JTextField quantidadePowerSplittersTextField;

    private JTextArea resultadosTextArea;

    public MainGUI() {
        setTitle("Calculadora PON");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Componentes de entrada de dados
        potenciaTransmissaoTextField = new JTextField(10);
        sensibilidadeRecepcaoTextField = new JTextField(10);
        atenuacaoFibraTextField = new JTextField(10);
        perdasPowerSplittersTextField = new JTextField(10);
        quantidadeConectoresTextField = new JTextField(10);
        quantidadePowerSplittersTextField = new JTextField(10);

        mainPanel.add(createInputPanel("Potência de transmissão:", potenciaTransmissaoTextField));
        mainPanel.add(createInputPanel("Sensibilidade de recepção:", sensibilidadeRecepcaoTextField));
        mainPanel.add(createInputPanel("Atenuação da fibra:", atenuacaoFibraTextField));
        mainPanel.add(createInputPanel("Perdas dos power splitters:", perdasPowerSplittersTextField));
        mainPanel.add(createInputPanel("Quantidade de conectores:", quantidadeConectoresTextField));
        mainPanel.add(createInputPanel("Quantidade de power splitters:", quantidadePowerSplittersTextField));

        // Botão de cálculo
        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(calcularButton);
        mainPanel.add(Box.createVerticalStrut(10));

        // Área de resultados
        resultadosTextArea = new JTextArea(10, 30);
        resultadosTextArea.setEditable(false);
        resultadosTextArea.setLineWrap(true);
        resultadosTextArea.setWrapStyleWord(true);
        JScrollPane resultadosScrollPane = new JScrollPane(resultadosTextArea);
        mainPanel.add(resultadosScrollPane);

        add(mainPanel);
    }

    private JPanel createInputPanel(String label, JTextField textField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(label));
        panel.add(textField);
        panel.setMaximumSize(panel.getPreferredSize());
        return panel;
    }

    private void calcular() {
        try {
            Double potenciaTransmissao = Double.parseDouble(potenciaTransmissaoTextField.getText());
            Double sensibilidadeRecepcao = Double.parseDouble(sensibilidadeRecepcaoTextField.getText());
            Double atenuacaoFibra = Double.parseDouble(atenuacaoFibraTextField.getText());
            Double perdasPowerSplitters = Double.parseDouble(perdasPowerSplittersTextField.getText());
            int quantidadeConectores = Integer.parseInt(quantidadeConectoresTextField.getText());
            int quantidadePowerSplitters = Integer.parseInt(quantidadePowerSplittersTextField.getText());

            CalculadorPON calculadorPON = new CalculadorPON(null, potenciaTransmissao, sensibilidadeRecepcao,
                    atenuacaoFibra, 0.2, perdasPowerSplitters, quantidadeConectores, quantidadePowerSplitters);

            Double distanciaMaxima = calculadorPON.calcularDistanciaMaxima();
            Double potenciaTransmissao_ = calculadorPON.calcularPotenciaTransmissao();
            Double sensibilidadeRecepcao_ = calculadorPON.calcularSensibilidadeRecepcao();
            Double atenuacaoFibra_ = calculadorPON.calcularAtenuacaoFibra();
            Double perdasConectores_ = calculadorPON.calcularPerdasConectores();
            Double perdasPowerSplitters_ = calculadorPON.calcularPerdasPowerSplitters();
            int quantidadeConectores_ = calculadorPON.calcularQuantidadeConectores();
            int quantidadePowerSplitters_ = calculadorPON.calcularQuantidadePowerSplitters();

            StringBuilder resultados = new StringBuilder();
            resultados.append("Distância máxima: ").append((distanciaMaxima)).append("\n");
            resultados.append("Potência de transmissão: ").append(potenciaTransmissao_).append("\n");
            resultados.append("Sensibilidade de recepção: ").append(sensibilidadeRecepcao_).append("\n");
            resultados.append("Atenuação da fibra: ").append(atenuacaoFibra_).append("\n");
            resultados.append("Perdas dos conectores: ").append(perdasConectores_).append("\n");
            resultados.append("Perdas dos power splitters: ").append(perdasPowerSplitters_).append("\n");
            resultados.append("Quantidade de conectores: ").append(quantidadeConectores_).append("\n");
            resultados.append("Quantidade de power splitters: ").append(quantidadePowerSplitters_).append("\n");

            resultadosTextArea.setText(resultados.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para os campos numéricos.",
                    "Erro de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainGUI gui = new MainGUI();
                gui.setVisible(true);
            }
        });
    }
}
