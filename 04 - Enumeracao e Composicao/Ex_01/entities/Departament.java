package entities;

public class Departament {
	
	//atributos
	private String name;
	
	//construtores
	public Departament(){
		
	}

	public Departament(String name) {
		this.name = name;
	}


	
	//get e set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	

}
