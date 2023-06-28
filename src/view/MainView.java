package view;
/**
 *
 * @author Ernane
 */

import calculos.CalculadorPON;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JTextField distanciaField;
    private JTextField potenciaField;
    private JTextField sensibilidadeField;
    private JTextField atenuacaoField;
    private JTextField perdasConectoresField;
    private JTextField perdasSplittersField;
    private JTextField quantidadeConectoresField;
    private JTextField quantidadeSplittersField;
    private JTextArea resultadoArea;

    public MainView() {
        setTitle("Calculadora PON");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        initComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Labels
        JLabel distanciaLabel = new JLabel("Distância:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(distanciaLabel, constraints);

        JLabel potenciaLabel = new JLabel("Potência de Transmissão:");
        constraints.gridy = 1;
        panel.add(potenciaLabel, constraints);

        JLabel sensibilidadeLabel = new JLabel("Sensibilidade de Recepção:");
        constraints.gridy = 2;
        panel.add(sensibilidadeLabel, constraints);

        JLabel atenuacaoLabel = new JLabel("Atenuação da Fibra:");
        constraints.gridy = 3;
        panel.add(atenuacaoLabel, constraints);

        JLabel perdasConectoresLabel = new JLabel("Perdas dos Conectores:");
        constraints.gridy = 4;
        panel.add(perdasConectoresLabel, constraints);

        JLabel perdasSplittersLabel = new JLabel("Perdas dos Power Splitters:");
        constraints.gridy = 5;
        panel.add(perdasSplittersLabel, constraints);

        JLabel quantidadeConectoresLabel = new JLabel("Quantidade de Conectores:");
        constraints.gridy = 6;
        panel.add(quantidadeConectoresLabel, constraints);

        JLabel quantidadeSplittersLabel = new JLabel("Quantidade de Power Splitters:");
        constraints.gridy = 7;
        panel.add(quantidadeSplittersLabel, constraints);

        // Text Fields
        distanciaField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(distanciaField, constraints);

        potenciaField = new JTextField(10);
        constraints.gridy = 1;
        panel.add(potenciaField, constraints);

        sensibilidadeField = new JTextField(10);
        constraints.gridy = 2;
        panel.add(sensibilidadeField, constraints);

        atenuacaoField = new JTextField(10);
        constraints.gridy = 3;
        panel.add(atenuacaoField, constraints);

        perdasConectoresField = new JTextField(10);
        constraints.gridy = 4;
        panel.add(perdasConectoresField, constraints);

        perdasSplittersField = new JTextField(10);
        constraints.gridy = 5;
        panel.add(perdasSplittersField, constraints);

        quantidadeConectoresField = new JTextField(10);
        constraints.gridy = 6;
        panel.add(quantidadeConectoresField, constraints);

        quantidadeSplittersField = new JTextField(10);
        constraints.gridy = 7;
        panel.add(quantidadeSplittersField, constraints);

        // Calculate Button
        JButton calcularButton = new JButton("Calcular");
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(calcularButton, constraints);

        // Result Area
        resultadoArea = new JTextArea(8, 20);
        resultadoArea.setEditable(false);
        resultadoArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        constraints.gridy = 9;
        panel.add(scrollPane, constraints);

        // Add panel to frame
        add(panel);

        // Button listener
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double distancia = getValueFromTextField(distanciaField);
                Double potenciaTransmissao = getValueFromTextField(potenciaField);
                Double sensibilidadeRecepcao = getValueFromTextField(sensibilidadeField);
                Double atenuacaoFibra = getValueFromTextField(atenuacaoField);
                Double perdasConectores = getValueFromTextField(perdasConectoresField);
                Double perdasPowerSplitters = getValueFromTextField(perdasSplittersField);
                Double quantidadeConectores = getValueFromTextField(quantidadeConectoresField);
                Double quantidadePowerSplitters = getValueFromTextField(quantidadeSplittersField);

                CalculadorPON calculadorPON = new CalculadorPON(distancia, potenciaTransmissao, sensibilidadeRecepcao,
                        atenuacaoFibra, perdasConectores, perdasPowerSplitters, quantidadeConectores, quantidadePowerSplitters);

                Double distanciaMaxima = calculadorPON.calcularDistanciaMaxima();
                Double potenciaTransmissao_ = calculadorPON.calcularPotenciaTransmissao();
                Double sensibilidadeRecepcao_ = calculadorPON.calcularSensibilidadeRecepcao();
                Double atenuacaoFibra_ = calculadorPON.calcularAtenuacaoFibra();
                Double perdasConectores_ = calculadorPON.calcularPerdasConectores();
                Double perdasPowerSplitters_ = calculadorPON.calcularPerdasPowerSplitters();
                Double quantidadeConectores_ = calculadorPON.calcularQuantidadeConectores();
                Double quantidadePowerSplitters_ = calculadorPON.calcularQuantidadePowerSplitters();

                resultadoArea.setText(
                        "Distância máxima: " + distanciaMaxima + "\n" +
                        "Potência de transmissão: " + potenciaTransmissao_ + "\n" +
                        "Sensibilidade de recepção: " + sensibilidadeRecepcao_ + "\n" +
                        "Atenuação da fibra: " + atenuacaoFibra_ + "\n" +
                        "Perdas dos conectores: " + perdasConectores_ + "\n" +
                        "Perdas dos power splitters: " + perdasPowerSplitters_ + "\n" +
                        "Quantidade de conectores: " + quantidadeConectores_ + "\n" +
                        "Quantidade de power splitters: " + quantidadePowerSplitters_
                );
            }
        });
    }

    private Double getValueFromTextField(JTextField textField) {
        String text = textField.getText().trim();
        return text.isEmpty() ? null : Double.parseDouble(text);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }
}
