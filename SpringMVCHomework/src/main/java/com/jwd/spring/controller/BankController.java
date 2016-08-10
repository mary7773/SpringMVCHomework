package com.jwd.spring.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwd.spring.currency.YahooCurrencyConverter;
import com.jwd.spring.model.Account;
import com.jwd.spring.repository.AccountRepository;
import com.jwd.spring.service.BankService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BankController {
	
	private static final Logger logger = LoggerFactory.getLogger(BankController.class);
	
	@Autowired
	private BankService bankService;
	@Autowired
	Account account;
	@Autowired
	private YahooCurrencyConverter currencyConverter;
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		logger.info("Welcome home! The client called the home() method");
		
		/*String[] operation =new String[2];
		double amount =0;
		
		operation[0] = "Deposit";
		operation[1] = "Withdraw";*/
				
		model.addAttribute("account", new Account());
		//model.addAttribute("operation", operation);
		
		
		
		return "home";
	}
	
	
	@RequestMapping(value = "/bankOperation", method = RequestMethod.POST)
	public String bankOperation(Model model,@ModelAttribute("account") Account account1) {
		logger.info("Welcome home! The client called the bankOperation() method");
		
//		System.out.println(account.getClientId());
//		System.out.println(account.getCurrentAmount());
//		System.out.println(account.getCurrency());
//		System.out.println(account.getOperation());
//		System.out.println(account.getAmount());
		
		
		
		boolean isAvailvabe = false;
		
		for (Account a : bankService.getAllAccounts()) {
			
			
			if (a.getClientId().equals(account1.getClientId())) {
				
				isAvailvabe = true;
				
				if (!a.getCurrency().equals(account1.getCurrency())) {
					
					try {
						double newAmount =account1.getAmount()*currencyConverter.convert(account1.getCurrency(),a.getCurrency());
						account1.setAmount(newAmount);
						System.out.println(newAmount);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				
				
				if (account1.getOperation().equals("Deposit")) {
					
					account = bankService.deposit(account1.getAmount(), account1.getClientId());
				}else {
					account = bankService.withdraw(account1.getAmount(), account1.getClientId());
				}
				
				break;
			}
		}
		
		if (!isAvailvabe) {			
			bankService.save(account1);
			
			if (account1.getOperation().equals("Deposit")) {
				
				account = bankService.deposit(account1.getAmount(), account1.getClientId());
			}
			
		
		}
			
		
		model.addAttribute("account", account);
		
		return "home";
	}
	
}
