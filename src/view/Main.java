package view;

import controller.CalculadorPON;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Double distancia = null;
        Double perdasConectores = 0.2;
        Double potenciaTransmissao;
        Double sensibilidadeRecepcao;
        Double atenuacaoFibra;
        Double perdasPowerSplitters;
        int quantidadeConectores;
        int quantidadePowerSplitters;
        
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Potência de transmissão: ");
            potenciaTransmissao = scanner.nextDouble();
            System.out.print("Sensibilidade de recepção: ");
            sensibilidadeRecepcao = scanner.nextDouble();
            System.out.print("Atenuação da fibra: ");
            atenuacaoFibra = scanner.nextDouble();
            System.out.print("Perdas dos conectores: 0.2 \n");
            System.out.print("Perdas dos power splitters: ");
            perdasPowerSplitters = scanner.nextDouble();
            System.out.print("Quantidade de conectores: ");
            quantidadeConectores = scanner.nextInt();
            System.out.print("Quantidade de power splitters: ");
            quantidadePowerSplitters = scanner.nextInt();
        }

        CalculadorPON calculadorPON = new CalculadorPON(distancia, potenciaTransmissao, sensibilidadeRecepcao,
                atenuacaoFibra, perdasConectores, perdasPowerSplitters, quantidadeConectores, quantidadePowerSplitters);

        Double distanciaMaxima = calculadorPON.calcularDistanciaMaxima();
        Double potenciaTransmissao_ = calculadorPON.calcularPotenciaTransmissao();
        Double sensibilidadeRecepcao_ = calculadorPON.calcularSensibilidadeRecepcao();
        Double atenuacaoFibra_ = calculadorPON.calcularAtenuacaoFibra();
        Double perdasConectores_ = calculadorPON.calcularPerdasConectores();
        Double perdasPowerSplitters_ = calculadorPON.calcularPerdasPowerSplitters();
        int quantidadeConectores_ = calculadorPON.calcularQuantidadeConectores();
        int quantidadePowerSplitters_ = calculadorPON.calcularQuantidadePowerSplitters();

        System.out.println("--------------------------------------");
        System.out.println("---------------RESULTADOS-------------");
        System.out.println("Distância máxima: " + Math.abs(distanciaMaxima));
        System.out.println("Potência de transmissão: " + potenciaTransmissao_);
        System.out.println("Sensibilidade de recepção: " + sensibilidadeRecepcao_);
        System.out.println("Atenuação da fibra: " + atenuacaoFibra_);
        System.out.println("Perdas dos conectores: " + perdasConectores_);
        System.out.println("Perdas dos power splitters: " + perdasPowerSplitters_);
        System.out.println("Quantidade de conectores: " + quantidadeConectores_);
        System.out.println("Quantidade de power splitters: " + quantidadePowerSplitters_);
        System.out.println("--------------------------------------");
    }
}
