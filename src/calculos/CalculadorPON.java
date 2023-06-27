package calculos;
/**
 *
 * @author Tarcio
 */
public class CalculadorPON {
    private Double distancia;
    private Double potenciaTransmissao;
    private Double sensibilidadeRecepcao;
    private Double atenuacaoFibra;
    private Double perdasConectores;
    private Double perdasPowerSplitters;
    private int quantidadeConectores;
    private int quantidadePowerSplitters;

    public CalculadorPON(Double distancia, Double potenciaTransmissao, Double sensibilidadeRecepcao,
                          Double atenuacaoFibra, Double perdasConectores, Double perdasPowerSplitters,
                          int quantidadeConectores, int quantidadePowerSplitters) {
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
            double potenciaTransmissao_ = (distancia * atenuacaoFibra) + sensibilidadeRecepcao
                    + (quantidadeConectores * perdasConectores) + (quantidadePowerSplitters * perdasPowerSplitters);
            return potenciaTransmissao_;
        } else {
            return potenciaTransmissao;
        }
    }

    public Double calcularSensibilidadeRecepcao() {
        if (sensibilidadeRecepcao == null) {
            double sensibilidadeRecepcao_ = potenciaTransmissao - (distancia * atenuacaoFibra)
                    - (quantidadeConectores * perdasConectores) - (quantidadePowerSplitters * perdasPowerSplitters);
            return sensibilidadeRecepcao_;
        } else {
            return sensibilidadeRecepcao;
        }
    }

    public Double calcularAtenuacaoFibra() {
        if (atenuacaoFibra == null) {
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
            perdasConectores = (potenciaTransmissao - sensibilidadeRecepcao
                    - (quantidadePowerSplitters * perdasPowerSplitters) * atenuacaoFibra) / quantidadeConectores;
            return perdasConectores;
        } else {
            return perdasConectores;
        }
    }

    public Double calcularPerdasPowerSplitters() {
        if (perdasPowerSplitters == null) {
            perdasPowerSplitters = (potenciaTransmissao - sensibilidadeRecepcao
                    - (quantidadeConectores * perdasConectores) * atenuacaoFibra) / quantidadePowerSplitters;
            return perdasPowerSplitters;
        } else {
            return perdasPowerSplitters;
        }
    }

    public int calcularQuantidadeConectores() {
        if (quantidadeConectores == 0) {
            quantidadeConectores = (int) Math.ceil((potenciaTransmissao - sensibilidadeRecepcao
                    - (quantidadePowerSplitters * perdasPowerSplitters) * atenuacaoFibra) / perdasConectores);
            return quantidadeConectores;
        } else {
            return quantidadeConectores;
        }
    }

    public int calcularQuantidadePowerSplitters() {
        if (quantidadePowerSplitters == 0) {
            quantidadePowerSplitters = (int) Math.ceil((potenciaTransmissao - sensibilidadeRecepcao
                    - (quantidadeConectores * perdasConectores) * atenuacaoFibra) / perdasPowerSplitters);
            return quantidadePowerSplitters;
        } else {
            return quantidadePowerSplitters;
        }
    }
}
