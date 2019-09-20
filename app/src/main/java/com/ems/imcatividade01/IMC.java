package com.ems.imcatividade01;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Edson Melo de Souza
 */
public final class IMC implements Serializable {

    private float peso;
    private Double altura;
    private Double imc;
    private String mensagem;

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getImc() {
        return imc;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void calcularIMC() {
        imc = peso / Math.pow(altura, 2);
        faixas();
    }

    private void faixas() {
        ArrayList<FaixasImc> listaDeFaixas = new ArrayList<>();

        listaDeFaixas.add(new FaixasImc("Baixo peso muito grave", 00.00, 15.99));
        listaDeFaixas.add(new FaixasImc("Baixo peso grave", 16.00, 16.99));
        listaDeFaixas.add(new FaixasImc("Baixo peso ", 17.00, 18.49));
        listaDeFaixas.add(new FaixasImc("Peso Normal", 18.50, 24.99));
        listaDeFaixas.add(new FaixasImc("Sobrepeso", 25.00, 29.99));
        listaDeFaixas.add(new FaixasImc("Obesidade Grau I", 30.00, 34.99));
        listaDeFaixas.add(new FaixasImc("Obesidade Grau II", 35.00, 39.99));
        listaDeFaixas.add(new FaixasImc("Obesidade Grau III (Mórbida)", 40.00, 99.99));

        for (FaixasImc faixas_tmp : listaDeFaixas) {
            if (this.imc >= faixas_tmp.getVlInicial() && this.imc <= faixas_tmp.getVlFinal()) {
                this.mensagem = faixas_tmp.getMensagem();
            }
        }
    }
}

/**
 * Calcula as faixas de mensagem para o IMC
 *
 * @author Edson Melo de Souza
 */
class FaixasImc {

    private String mensagem;
    private double vlInicial;
    private double vlFinal;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public double getVlInicial() {
        return vlInicial;
    }

    public void setVlInicial(double vlInicial) {
        this.vlInicial = vlInicial;
    }

    public double getVlFinal() {
        return vlFinal;
    }

    public void setVlFinal(double vlFinal) {
        this.vlFinal = vlFinal;
    }

    public FaixasImc(String mensagem, double vlInicial, double vlFinal) {
        this.mensagem = mensagem;
        this.vlInicial = vlInicial;
        this.vlFinal = vlFinal;
    }

}