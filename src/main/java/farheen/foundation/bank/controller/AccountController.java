package farheen.foundation.bank.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import farheen.foundation.bank.commons.NotFoundException;
import farheen.foundation.bank.entities.Account;
import farheen.foundation.bank.entities.FundTransferEntity;
import farheen.foundation.bank.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/api/accounts")
	public List<Account> getAccounts(){
		List<Account> accounts = accountService.getAccounts();
		return accounts;
	}
	//GET /api/accounts/{accountNumber}
	
	@RequestMapping(value="/api/accounts/{accountNumber}", method = RequestMethod.GET)
	public Account getAccount(@PathVariable int accountNumber) {
		Account account = accountService.getAccount(accountNumber);
		if(account == null) {
			throw new NotFoundException("Account with AccountNumber"+ accountNumber+" does not exist");
			
		}
		return account;
	}
	
	@PutMapping(value="/api/accounts/transferFunds")
	@Transactional
	public String fundTransfer(@RequestBody FundTransferEntity fundTransfer) {
		String fundTransferStatus = accountService.fundTransfer(fundTransfer);
		return fundTransferStatus;
	}
}
