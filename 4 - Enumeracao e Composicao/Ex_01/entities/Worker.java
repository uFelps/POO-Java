package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import enumeradas.WorkerLevel;

public class Worker {

	// atributos
	private String name;
	private WorkerLevel workerLevel;
	private Double baseSalary;
	// associações
	private Departament departament;
	private List<HourContract> contracts = new ArrayList<>();

	// construtores
	public Worker() {

	}

	public Worker(String name, WorkerLevel workerLevel, Double baseSalary, Departament departament) {
		this.name = name;
		this.workerLevel = workerLevel;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	// get e set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return workerLevel;
	}

	public void setLevel(WorkerLevel workerLevel) {
		this.workerLevel = workerLevel;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	// metodos
	@Override
	public String toString() {
		return "\nName: " + name + ", workerLevel: " + workerLevel + ", baseSalary: " + baseSalary + ", departament: "
				+ departament + ", contracts=" + contracts + "]";
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	public Double income(Integer year, Integer month) {
		// soma final
		Double sum = baseSalary;

		// instanciando um objeto do tipo calendar
		Calendar cal = Calendar.getInstance();

		// laço para percorrer todos os contratos
		for (HourContract contract : contracts) {

			// definindo a data do objeto calendar igual a data do contrato
			cal.setTime(contract.getDate());

			// pegando o ano e mes da data do contrato
			double yearContract = cal.get(Calendar.YEAR);
			double monthContract = 1 + cal.get(Calendar.MONTH);

			// se a data do contrato for igual aos parametros passados..
			if (yearContract == year && monthContract == month) {

				sum += contract.totalValue();
			}
		}

		return sum;
	}

}
