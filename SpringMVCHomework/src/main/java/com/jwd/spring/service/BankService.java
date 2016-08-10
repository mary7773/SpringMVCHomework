package com.jwd.spring.service;

import java.util.List;

import com.jwd.spring.model.Account;

public interface BankService {
	
	Account deposit(double amount, String clientId);
	Account withdraw(double amount, String clientId);	
	List<Account> getAllAccounts();
	void save(Account account);

}
