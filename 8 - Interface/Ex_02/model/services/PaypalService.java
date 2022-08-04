package model.services;

public class PaypalService implements PaymentService {
	
	public static final double PAYMENT_TAX = 0.02;
	public static final double MONTH_SIMPLE_INTEREST = 0.01;
	
	@Override
	public Double paymentFee(Double amount) {
		return amount * PAYMENT_TAX;
	}
	
	@Override
	public Double interest(Double amount, int month) {
		return amount * MONTH_SIMPLE_INTEREST * month;
	}

}
