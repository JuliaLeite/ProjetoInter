package calculos;
/**
 *
 * @author Ernane
 */
public class CalculadorPON {
    private Double distancia;
    private Double potenciaTransmissao;
    private Double sensibilidadeRecepcao;
    private Double atenuacaoFibra;
    private Double perdasConectores;
    private Double perdasPowerSplitters;
    private Double quantidadeConectores;
    private Double quantidadePowerSplitters;

    public CalculadorPON(Double distancia, Double potenciaTransmissao, Double sensibilidadeRecepcao,
                          Double atenuacaoFibra, Double perdasConectores, Double perdasPowerSplitters,
                          Double quantidadeConectores, Double quantidadePowerSplitters) {
        this.distancia = distancia;
        this.potenciaTransmissao = potenciaTransmissao;
        this.sensibilidadeRecepcao = sensibilidadeRecepcao;
        this.atenuacaoFibra = atenuacaoFibra;
        this.perdasConectores = perdasConectores;
        this.perdasPowerSplitters = perdasPowerSplitters;
        this.quantidadeConectores = quantidadeConectores;
        this.quantidadePowerSplitters = quantidadePowerSplitters;
    }

        public Double calcularDistanciaMaxima() {
        if (distancia == null) {
            // Cálculo da distância máxima
            double distanciaMaxima = (potenciaTransmissao - sensibilidadeRecepcao
                    - (quantidadeConectores * perdasConectores)
                    - (quantidadePowerSplitters * perdasPowerSplitters)) / atenuacaoFibra;
            return distanciaMaxima;
        } else {
            return distancia;
        }
    }

    public Double calcularPotenciaTransmissao() {
        if (potenciaTransmissao == null) {
            // Cálculo da potência de transmissão
            double potenciaTransmissao_ = (distancia * atenuacaoFibra) + sensibilidadeRecepcao
                    + (quantidadeConectores * perdasConectores) + (quantidadePowerSplitters * perdasPowerSplitters);
            return potenciaTransmissao_;
        } else {
            return potenciaTransmissao;
        }
    }

    public Double calcularSensibilidadeRecepcao() {
        if (sensibilidadeRecepcao == null) {
            // Cálculo da sensibilidade de recepção
            double sensibilidadeRecepcao_ = potenciaTransmissao - (distancia * atenuacaoFibra)
                    - (quantidadeConectores * perdasConectores) - (quantidadePowerSplitters * perdasPowerSplitters);
            return sensibilidadeRecepcao_;
        } else {
            return sensibilidadeRecepcao;
        }
    }

    public Double calcularAtenuacaoFibra() {
        if (atenuacaoFibra == null) {
            // Cálculo da atenuação da fibra
            double atenuacaoFibra_ = (potenciaTransmissao - sensibilidadeRecepcao
                    - (quantidadeConectores * perdasConectores)
                    - (quantidadePowerSplitters * perdasPowerSplitters)) / distancia;
            return atenuacaoFibra_;
        } else {
            return atenuacaoFibra;
        }
    }

    public Double calcularPerdasConectores() {
        if (perdasConectores == null) {
            // Calcula perdasConectores com base na fórmula corrigida
            perdasConectores = ((potenciaTransmissao - sensibilidadeRecepcao)
                    - (quantidadePowerSplitters * perdasPowerSplitters) - (distancia * atenuacaoFibra)) / quantidadeConectores;
            return perdasConectores;
        } else {
            return perdasConectores;
        }
    }

    public Double calcularPerdasPowerSplitters() {
        if (perdasPowerSplitters == null) {
            // Calcula perdasPowerSplitters com base na fórmula corrigida
            perdasPowerSplitters = ((potenciaTransmissao - sensibilidadeRecepcao)
                    - (quantidadeConectores * perdasConectores) - (distancia * atenuacaoFibra)) / quantidadePowerSplitters;
            return perdasPowerSplitters;
        } else {
            return perdasPowerSplitters;
        }
    }

    public Double calcularQuantidadeConectores() {
        if (quantidadeConectores == null) {
            // Calcula quantidadeConectores com base na fórmula corrigida
            quantidadeConectores = ((potenciaTransmissao - sensibilidadeRecepcao)
                    - (quantidadePowerSplitters * perdasPowerSplitters) - (distancia * atenuacaoFibra)) / perdasConectores;
            return quantidadeConectores;
        } else {
            return quantidadeConectores;
        }
    }

    public Double calcularQuantidadePowerSplitters() {
        if (quantidadePowerSplitters == null) {
            // Calcula quantidadePowerSplitters com base na fórmula corrigida
            quantidadePowerSplitters = ((potenciaTransmissao - sensibilidadeRecepcao)
                    - (quantidadeConectores * perdasConectores) - (distancia * atenuacaoFibra)) / perdasPowerSplitters;
            return quantidadePowerSplitters;
        } else {
            return quantidadePowerSplitters;
        }
    }}