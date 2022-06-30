package entities;

public abstract class Pessoa {
	
	//atributos
	private String nome;
	private Double rendaAnual;
	
	//construtores
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, Double rendaAnual) {
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}

	// get e set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getRendaAnual() {
		return rendaAnual;
	}

	public void setRendaAnual(Double rendaAnual) {
		this.rendaAnual = rendaAnual;
	}
	
	//metodos
	public abstract Double calcularImposto();

}
