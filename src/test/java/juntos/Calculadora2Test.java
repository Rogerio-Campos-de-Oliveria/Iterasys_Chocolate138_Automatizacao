package juntos;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Calculadora2Test {
    @Test
    public void testeSomar() {
        // Configura - Arrange
        double num1 = 5;
        double num2 = 7;
        double resultadoEsperado = 12;

        // Executa - Act
        double resultadoAtual = Calculadora2.somar(num1, num2);

        // Valida - Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeSubtrair() {
        // Configura - Arrange
        double num1 = 15;
        double num2 = 4;
        double resultadoEsperado = 11;

        // Executa - Act
        double resultadoAtual = Calculadora2.subtrair(num1, num2);

        // Valida - Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeMultiplicar() {
        // Configura - Arrange
        double num1 = 8;
        double num2 = 15;
        double resultadoEsperado = 120;

        // Executa - Act
        double resultadoAtual = Calculadora2.multiplicar(num1, num2);

        // Valida - Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeDividir() {
        // Configura - Arrange
        double num1 = 1500;
        double num2 = 75;
        double resultadoEsperado = 20;

        // Executa - Act
        double resultadoAtual = Calculadora2.dividir(num1, num2);

        // Valida - Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }
    @Test
    public void testeDividirPorZero() {
        // Configura - Arrange
        double num1 = 100;
        double num2 = 0;
        double resultadoEsperado = Double.NaN;

        // Executa - Act e Valida - Assert
        double resultadoAtual = Calculadora2.dividir(num1, num2);

        // Valida - Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

}
