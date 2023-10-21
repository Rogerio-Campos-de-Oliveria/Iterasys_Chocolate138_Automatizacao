package br.com.iterasys;

public class Main {
    public static void main(String[] args){
        System.out.println("Olá, Mundo!");
        chamarEncomenda();
        Calculadora.somarInteiros(5,7);
        Calculadora.menosInteiros(15, 4);
        Calculadora.multiplicacaoInteiros(80,15);
        Calculadora.divisaoInteiros(1500, 75);

    }

    public static void chamarEncomenda(){
        int barras = 30;
        Encomenda.calcularBarrasDeChocolatesPorCaixa(barras);
    }
}