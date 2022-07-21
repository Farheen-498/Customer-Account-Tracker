package farheen.foundation.bank.service;

import java.util.List;

import farheen.foundation.bank.entities.Account;
import farheen.foundation.bank.entities.FundTransferEntity;

public interface AccountService {

	public Account getAccount(int accountNumber);
	public List<Account> getAccounts();
	public Account createAccount(Account account);
	public Account updateAccount(int accountId, Account account);
	public Account deleteAccount(int accountId);
	String fundTransfer(FundTransferEntity fundTransfer);
	
	
}
