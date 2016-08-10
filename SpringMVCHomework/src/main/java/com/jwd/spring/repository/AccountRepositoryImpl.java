package com.jwd.spring.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.jwd.spring.model.Account;

@Repository
public class AccountRepositoryImpl implements AccountRepository{

List<Account> accounts = new ArrayList<Account>();
	
	@Override
	public List<Account> getAllAccounts() {
		
		
		
		for (int i = 0; i < 10; i++) {
			
			Account acc = new Account();
			
			acc.setClientId("client" + i);
			acc.setCurrency("BGN");
			acc.setCurrentAmount(500*i);
			accounts.add(acc);
			
		}
		return accounts;
	}

	@Override
	public void save(Account account) {
		accounts.add(account);
	}

}
