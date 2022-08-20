package entities;

public class Aluno {
	
	public String nome;
	public double nota1;
	public double nota2;
	public double nota3;
	
	
	public double notaFinal() {
		return nota1 + nota2 + nota3;
	}
	
	public String situação() {
		
		if(notaFinal() >= 60.00) {
			return "\nPASS";
			
		} else {
			double remaining = 60 - notaFinal();
	
			return "\nFAILED \nMISSING "+ remaining + " POINTS";
		}
	}
	
	public String toString() {
		return "\nFINAL GRADE = "
			+ String.format("%.2f", notaFinal())
			+ situação();
	}

}
