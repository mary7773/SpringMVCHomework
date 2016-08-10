package com.jwd.spring.model;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.jwd.spring.exceptions.BankOperationExeption;

@Component
public class Account{
	
	private String clientId;
	private double currentAmount;
	private String currency;
	private String operation;
	private DateTime withdrawDate;
	private double amount;
		

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public double getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(double currentAmount) {
		this.currentAmount = currentAmount;
	}


	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public DateTime getWithdrawDate() {
		return withdrawDate;
	}

	public void setWithdrawDate(DateTime withdrawDate) {
		this.withdrawDate = withdrawDate;
	}

	public void setCurrency(String currency) {
		 this.currency = currency;
	}
	

	public String getCurrency() {
		return this.currency;
	}

}
