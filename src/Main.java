import java.text.DecimalFormat;
import java.util.Scanner;

/*
    Esse programa Calcula o Salário Líquido, baseado no calculo do INSS
 */
public class Main
{
    public static void main(String[] args)
    {
        CalculadoraSalarial calculadora;
        calculadora = new CalculadoraSalarial();
        calculadora.calcularSalario();
    }
}