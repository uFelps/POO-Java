package entities;

public class PessoaJuridica extends Pessoa{
	
	//atributos
	private Integer numeroFuncionarios;
	
	//construtores
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	//get e set
	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	//metodos
	@Override
	public Double calcularImposto() {
		
		double imposto = 0.0;
		
		if(numeroFuncionarios <= 10) {
			imposto += getRendaAnual() * 0.16;
		}
		else {
			imposto += getRendaAnual() * 0.14;
		}
		
		return imposto;
	}

}
