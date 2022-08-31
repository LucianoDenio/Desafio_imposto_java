import java.util.Locale;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double salarioAno, ganhoServico, ganhoCapital, gastoMedico, gastoEducacao, impostoSalario, impostoServico,  impostoCapital, maxDedutivel, gastDedutivel, bruto, abatimento, devido;
		
		System.out.print("Renda anual com salário: ");
		salarioAno = sc.nextDouble();
		System.out.print("Renda anual com prestação de serviço: ");
		ganhoServico = sc.nextDouble();
		System.out.print("Renda anual com ganho de capital: ");
		ganhoCapital = sc.nextDouble();
		System.out.print("Gastos Medicos :");
		gastoMedico = sc.nextDouble();
		System.out.print("Gastos Educacionais :");
		gastoEducacao = sc.nextDouble();
		System.out.println();
		
		System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
		System.out.println();
		
		System.out.println("CONSOLIDADO DE RENDA:");
		
		if(salarioAno/12 < 3000) {
			impostoSalario = 0;
		}
		else if(salarioAno/12 < 5000 ){
			impostoSalario = salarioAno/100 * 10;
		}
		else {
			impostoSalario = salarioAno/100 * 20;
		}
		System.out.printf("Imposto sobre salário: %.2f%n", impostoSalario);
		
		impostoServico = (ganhoServico > 0) ? ganhoServico/100*15 : 0;
				
		System.out.printf("Imposto sobre serviços: %.2f%n", impostoServico);
		
		impostoCapital = (ganhoCapital > 0) ? ganhoCapital/100*20 : 0;
				
		System.out.printf("Imposto sobre ganho de capital: %.2f%n", impostoCapital);
		System.out.println();
		
		System.out.println("DEDUÇÕES:");
		
		bruto = impostoSalario + impostoServico + impostoCapital;
		gastDedutivel = gastoMedico + gastoEducacao;
		maxDedutivel = bruto/100 *30;
		
		System.out.printf("Máximo dedutível: %.2f%n",maxDedutivel);
		System.out.printf("Gastos dedutíveis: %.2f%n",gastDedutivel);
		System.out.println();
		
		abatimento = (gastDedutivel > bruto) ? maxDedutivel : gastDedutivel;
		devido = bruto - abatimento;
		
		System.out.println("RESUMO: ");
		System.out.printf("Imposto bruto total: %.2f %n", bruto);
		System.out.printf("Abatimento: %.2f %n", abatimento);
		System.out.printf("Imposto devido: %.2f %n", devido);
		
		sc.close();
	}
}
