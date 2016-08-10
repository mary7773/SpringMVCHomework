package com.jwd.spring.repository;

import java.util.List;

import com.jwd.spring.model.Account;

public interface AccountRepository {
	
	List<Account> getAllAccounts();
	void save(Account account);

}
