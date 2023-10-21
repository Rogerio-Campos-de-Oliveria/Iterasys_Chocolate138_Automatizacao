package br.com.iterasys;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");
        chamarEncomenda();
    }

    public static void chamarEncomenda(){
        int barras = 30;
        Encomenda.calcularBarrasDeChocolatesPorCaixa(barras);
    }
}