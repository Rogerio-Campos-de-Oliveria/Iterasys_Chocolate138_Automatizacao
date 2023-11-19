package br.com.iterasys;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AreasAulaTest {


    @Test
    public void testarCalcularQuadrado(){
        //Configura
        double lado = 3;
        double resultadoEsperado = 9;

        //Executa
        double resultadoAtual = AreasAula.calcularQuadrado(lado);

        //Valida
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testCalcularRetangulo() {
        // Configura - Arrange
        double largura = 4.0;
        double comprimento = 6.0;
        double resultadoEsperado = 24.0;

        // Executa - Act
        double resultadoAtual = new AreasAula().calcularRetangulo(largura, comprimento);

        // Valida - Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testCalcularTriangulo() {
        // Configura - Arrange
        double base = 3.0;
        double altura = 8.0;
        double resultadoEsperado = 12.0;

        // Executa - Act
        double resultadoAtual = new AreasAula().calcularTriangulo(base, altura);

        // Valida - Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testCalcularCirculo() {
        // Configura - Arrange
        double raio = 2.5;
        double resultadoEsperado = Math.PI * Math.pow(raio, 2);

        // Executa - Act
        double resultadoAtual = new AreasAula().calcularCirculo(raio);

        // Valida - Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado, 0.01);
    }

}
