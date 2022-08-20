package entities;

public class PessoaFisica extends Pessoa {

	//atributos
	public Double gastoSaude;
	
	//construtores
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String nome, Double rendaAnual, Double gastoSaude) {
		super(nome, rendaAnual);
		this.gastoSaude = gastoSaude;
	}

	// get e set	
	public Double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}

	//metodos
	@Override
	public Double calcularImposto() {
		
		double imposto = 0.0;
		
		if(getRendaAnual() < 2000.00) {
			imposto += getRendaAnual() * 0.15;
		}
		
		else {
			imposto += getRendaAnual() * 0.25;
		}
		
		if(gastoSaude > 0.0) {
			imposto -= gastoSaude * 0.50;
		}
		
		return imposto;
	}
}
