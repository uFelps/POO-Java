package model.entities;

import model.exceptions.BusinessException;

public class Account {

	// atributos
	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;

	// construtores
	public Account() {

	}

	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}

	// get e set
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}

	public void setWithDrawLimit(Double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}

	public Double getBalance() {
		return balance;
	}

	// metodos
	public void deposit(double amount) {
		balance += amount;
	}

	public void withDraw(Double amount) throws BusinessException {

		if (amount > withDrawLimit) {
			throw new BusinessException("Withdraw error: the amount exceeds withdraw limit");
		}
		
		if (amount > balance) {
			throw new BusinessException("Withdraw error: Not enough balance");
		}
		

		balance -= amount;
	}

}
