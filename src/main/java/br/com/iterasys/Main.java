package br.com.iterasys;

public class Main {
    public static void main(String[] args){
        System.out.println("Olá, Mundo!");
        System.out.println("---------------------------------");
        chamarEncomenda();
        System.out.println("---------------------------------");
        Calculadora.somarInteiros(5,7);
        System.out.println("---------------------------------");
        Calculadora.menosInteiros(15, 4);
        System.out.println("---------------------------------");
        Calculadora.multiplicacaoInteiros(80,15);
        System.out.println("---------------------------------");
        Calculadora.divisaoInteiros(1500, 75);

    }

    public static void chamarEncomenda(){
        int barras = 30;
        Encomenda.calcularBarrasDeChocolatesPorCaixa(barras);
    }
}