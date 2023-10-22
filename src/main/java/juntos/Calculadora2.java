package juntos;
public class Calculadora2 {

    public static double somar(double num1, double num2) {
        double soma = num1 + num2;
        System.out.println("Soma de " + num1 + " + " + num2 + " = " + soma);
        return soma;
    }

    public static double subtrair(double num1, double num2) {
        double diferenca = num1 - num2;
        System.out.println("Subtração de " + num1 + " - " + num2 + " = " + diferenca);
        return diferenca;
    }

    public static double multiplicar(double num1, double num2) {
        double multiplicacao = num1 * num2;
        System.out.println("A multiplicação de " + num1 + " x " + num2 + " = " + multiplicacao);
        return multiplicacao;
    }

    public static double dividir(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Erro: Divisão por zero não é permitida.");
            return Double.NaN; // Retorna um valor especial para representar "não um número"
        }
        double divisao = num1 / num2;
        System.out.println("A divisão dos números " + num1 + " / " + num2 + " = " + divisao);
        return divisao;
    }
}
