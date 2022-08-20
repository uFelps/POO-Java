package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	//atributos
	private PaymentService paymentService;

	//construtor
	public ContractService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	//metodos
	public void processInstallments(Contract contract, int months) {

		double valorBaseParcelas = contract.getTotalValue() / months;

		for (int i = 1; i <= months; i++) {

			Date date = addMonth(contract.getDate(), i);

			double parcela = valorBaseParcelas + paymentService.interest(valorBaseParcelas, i);
			parcela += paymentService.paymentFee(parcela);

			contract.addInstallment(new Installment(date, parcela));
		}
	}

	public Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);

		return cal.getTime();
	}

}
