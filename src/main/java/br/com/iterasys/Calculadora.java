package br.com.iterasys;

public class Calculadora {

    public static int somarInteiros(int num1, int num2){
        int soma = num1 + num2;
        System.out.println("Soma de " + num1 + " + " + num2 + " = " + soma);
        return soma;

    }

    public static int menosInteiros(int num1, int num2){
        int menos = num1 + num2;
        System.out.println("Subtração de " + num1 + " + " + num2 + " = " + menos);
        return menos;

    }
    public  static int multiplicacaoInteiros(int num1, int num2){
        int multiplicacao = num1 * num2;
        System.out.println("A multiplicação de " + num1 + " x " + num2 + " = " + multiplicacao);
        return multiplicacao;
    }

    public static int divisaoInteiros(int num1, int num2){
        int divisao = num1 / num2;
        System.out.println("A divisão dos números " + num1 + " / " + num2 + " = " + divisao);
        return divisao;
    }
}
