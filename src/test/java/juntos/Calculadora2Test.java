// 1 - Pacote
package juntos;

// 2 - Bibliotecas
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

// 3 - Classe
public class Calculadora2Test {
    // 3.1 - Atributos
    // Por enquanto sem atributos


    // 3.2 - Métodos e Funções


    // 3.2.1 - Uso Compartilhado
    @DataProvider(name = "MassaMultiplicar")
    public Object[][] massaMultiplicar(){
        return new Object [][] {
                {5, 7, 35},
                { 2, 10, 20},
                {20, 0, 0},
                {-5, 12, -60},
                {-5, -10, 50}


        }; // fecha o return
    }


    // 3.2.2.2 - Teste em si


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

    @Test(dataProvider = "MassaMultiplicar")
    public void testeMultiplicarDD(double num1, double num2, double resultadoEsperado) {
        // Configura - Arrange
        //Os dados são fornecidos para o teste através de uma lista

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
