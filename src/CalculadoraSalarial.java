import java.util.Scanner;
public class CalculadoraSalarial
{
    private double salarioBase;
    private double alimentacao;
    private double GAJ;
    private double AQFC;
    private double AQE;
    private double adicionais;
    private double descontoIRRF;
    private double descontoINSS;
    private double descontos;
    private double salarioBruto;
    private double salarioLiquido;
    public CalculadoraSalarial()
    {
        this.alimentacao = 2122;
    }

   public void calcularSalario()
    {
        this.informarSalario();
        this.calcularBeneficios();
        this.calcularDescontos();
        this.gerarRelatorioSalarial();
    }

    /**
     * Faz a captura do salário base digitado pelo usuario.
     *
     */
   private void informarSalario()
    {
        System.out.println("Digite seu Salário R$ : ");
        Scanner scanner = new Scanner(System.in);
        this.salarioBase = scanner.nextDouble();
        scanner.close();
    }

    /**
     * Faz o calculo dos beneficios e adiciona ao valor do salário base.
     *
     */
   private void calcularBeneficios()
    {
        this.alimentacao = 2122;
        this.GAJ = gratificacaoAtividadeJudiciaria();
        this.AQFC = adicionalQualicicacaoContinuada();
        this.AQE = adicionalQualificacaoEstavel();
        this.adicionais = this.AQFC + this.AQE;
    }

    /**
     * Faz o calculo dos descontos e deduz o valor do salário base.
     *
     */
   private void calcularDescontos()
    {
        this.descontoIRRF = calcularAlicotaIRRF();
        this.descontoINSS = calcularAlicotaINSS();
        this.descontos = this.descontoINSS + this.descontoIRRF;
        this.salarioBruto = this.salarioBase + this.alimentacao + this.adicionais + this.GAJ;
        this.salarioLiquido = this.salarioBruto - this.descontos;
    }

    /**
     * Faz a adição de uma porcentagem ao salario base
     */
    private double gratificacaoAtividadeJudiciaria()
    {
        double porcentagem = 30; // A porcentagem a ser somada (30% )
        return this.salarioBase * (porcentagem / 100);
    }

    /**
     * Faz a adição de uma porcentagem ao salario base
     *
     */
    private double adicionalQualicicacaoContinuada()
    {
        double porcentagem = 3;
        return this.salarioBase * (porcentagem / 100);
    }

    /**
     * Faz a adição de uma porcentagem ao salario base
     *
     */
    private double adicionalQualificacaoEstavel()
    {
        double porcentagem = 7.5;
        return this.salarioBase * (porcentagem / 100);
    }

    /**
     * Calcula o Imposto de renda baseado na tabela de calculo referente o ano de 2024.
     *
     */
    private double calcularAlicotaIRRF()
    {
        this.verificarSalarioNegativo();

        if (this.salarioBase >3036 && this.salarioBase <=3533 )
            return this.salarioBase * 0.075;

        if (this.salarioBase >3533 && this.salarioBase <=4688 )
            return this.salarioBase * 0.15;

        if (this.salarioBase >4688 && this.salarioBase <=5830 )
            return this.salarioBase * 0.225;

        return this.salarioBase * 0.275;
    }

    /**
     * Calcula o Alicota do INSS baseado na tabela de calculo referente o ano de 2024.
     *
     */
    private double calcularAlicotaINSS()
    {
        this.verificarSalarioNegativo();

        if(this.salarioBase >=0 && this.salarioBase <= 1518)
            return this.salarioBase * 0.075;

        if (this.salarioBase >1518 && this.salarioBase <= 2793)
            return this.salarioBase * 0.9 ;

        if(this.salarioBase >2973 && this.salarioBase <= 4190)
            return this.salarioBase * 0.12 ;

        return this.salarioBase * 0.14;
    }

    /**
     * Verifica se salário digitado pelo usuario não é negativo.
     *
     */
   private void verificarSalarioNegativo()
    {
        if (this.salarioBase < 0)
            throw new IllegalArgumentException("O número não pode ser negativo.");
    }

    /**
     * Gera o relatório salarial baseado no salario base com adicao dos beneficios e subitracao do INSS e IRRF.
     *
     */
   private void gerarRelatorioSalarial()
    {
        System.out.println("\n***************Relatório Salarial***************\n");
        /* Mostrar Salário Base */
        System.out.println("Salário Base: R$ " + String.format("%.2f", this.salarioBase));
        /* Mostrar o Adicional de Gratificação Judiciaria */
        System.out.println("Gratifica de atividade judiciaria: R$ " + String.format("%.2f",this.GAJ));
        /* Mostrar Alimentacao */
        System.out.println("Auxilio Alimentaço: R$ " + String.format("%.2f", this.alimentacao));
        /* Mostrar gratificacao AQFC */
        System.out.println("AQFC: R$ " + String.format("%.2f", this.AQFC));
        /* Mostrar graticacao AQE */
        System.out.println("AQE: R$ " + String.format("%.2f",this.AQE ));
        System.out.println("\n");
        /* Mostrar o Salário Bruto */
        System.out.println("Salário Bruto: R$ " + String.format("%.2f", this.salarioBruto));
        System.out.println("\n***************Descontos***************\n");
        /* Mostrar alicota do INSS */
        System.out.println("INSS: R$ " + String.format("%.2f", this.descontoINSS));
        /* Calcular alicota do Imposto de Renda IRRF */
        System.out.println("IRRF: R$ " + String.format("%.2f", this.descontoIRRF));
        /* Mostrar desconto Total */
        System.out.println("Desconto Total: R$ " + String.format("%.2f", this.descontos));
        System.out.println("\n");
        /* Mostrar Salário Liquido */
        System.out.println("Salário Líquido: R$ " + String.format("%.2f",this.salarioLiquido ));
    }
}
