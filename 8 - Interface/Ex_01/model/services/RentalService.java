package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	// atributos
	private Double pricePerHour;
	private Double pricePerDay;

	// associacoes
	private TaxService taxService;

	// construtor
	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	// get e set
	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public TaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}
	
	//metodos
	public void processInvoice(CarRental carRental) {
		
		long start = carRental.getStart().getTime();
		long finish = carRental.getFinish().getTime();
		
		double diff = (double) (finish - start) / 1000 / 60 / 60;
		
		double basicPayment;
		
		if(diff <= 12) {
			basicPayment = getPricePerHour() * Math.ceil(diff);
		}
		else {
			basicPayment = getPricePerDay() * Math.ceil(diff / 24);
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}

}
