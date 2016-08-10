package com.jwd.spring.service;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwd.spring.exceptions.BankOperationExeption;
import com.jwd.spring.model.Account;
import com.jwd.spring.repository.AccountRepository;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private AccountRepository accountRepo;

	@Override
	public Account deposit(double amount, String clientId) {

		for (Account account : accountRepo.getAllAccounts()) {

			if (account.getClientId().equals(clientId)) {
				try {
					checkTheAmount(amount, account);
					return account;
				} catch (BankOperationExeption e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	@Override
	public Account withdraw(double amount, String clientId) {

		for (Account account : accountRepo.getAllAccounts()) {

			if (account.getClientId().equals(clientId)) {
				try {
					checkTheAmountForWithdraw(amount, account);
					return account;
				} catch (BankOperationExeption e) {
					e.printStackTrace();
				}
			}
		}
			return null;
		
	}

	private void checkTheAmountForWithdraw(double amount, Account account) throws BankOperationExeption{
		
		DateTime first = new DateTime();
		DateTime second = new DateTime();

		if (account.getWithdrawDate() != null) {
			first = account.getWithdrawDate();
		}
		
		LocalDate firstDate = first.toLocalDate();
		LocalDate secondDate = second.toLocalDate();
		
		if (amount > 0 && (amount < account.getCurrentAmount()/2 && (firstDate.compareTo(secondDate) ==0))) {
			account.setCurrentAmount(account.getCurrentAmount() - amount);
			
			System.out.println("Bank Acount amount " +  account.getAmount());
		} else {
			throw new BankOperationExeption(
					"The specified amount is incorrect or you are not allowed to withdraw the requested amount!");
		}
	}

	private void checkTheAmount(double amount, Account account) throws BankOperationExeption {
		if (amount > 0) {
			account.setCurrentAmount(account.getCurrentAmount() + amount);

		} else {
			throw new BankOperationExeption("The amount is incorrect!");
		}
	}

	@Override
	public List<Account> getAllAccounts() {		
		List<Account> list = accountRepo.getAllAccounts();
		return list;
	}

	@Override
	public void save(Account account) {
		accountRepo.save(account);
	}
}
