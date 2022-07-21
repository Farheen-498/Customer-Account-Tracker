package farheen.foundation.bank.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import farheen.foundation.bank.entities.Account;
import farheen.foundation.bank.entities.FundTransferEntity;
import farheen.foundation.bank.repositories.AccountRespository;

@Component
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRespository accountRepository;
	
	
	public Account getAccount(int accountNumber) {
		Optional<Account> findById = accountRepository.findById(accountNumber);
		Account account= findById.get();
		return account;
		
	}


	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		List<Account> accounts = (List<Account>) accountRepository.findAll();
		return accounts;
	}


	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}


	@Override
	public Account updateAccount(int accountNumber, Account account) {
		// TODO Auto-generated method stub
		Account updateAccount = null;
		Optional<Account> findById = accountRepository.findById(accountNumber);
		if(findById.isPresent()) {
			updateAccount = findById.get();
			if(updateAccount!=null) {
				updateAccount.setAccountType(account.getAccountType());
				updateAccount.setBalance(account.getBalance());
				accountRepository.save(updateAccount);
			}
		}
		return updateAccount;
	}


	@Override
	public Account deleteAccount(int accountNumber) {
		// TODO Auto-generated method stub
		
		Account deleteAccount = null;
		Optional<Account> findById = accountRepository.findById(accountNumber);
		if(findById.isPresent()) {
			deleteAccount = findById.get();
			if(deleteAccount!=null) {
				accountRepository.delete(deleteAccount);
			}
		}
		return deleteAccount;
	}


	@Override
	@Transactional
	public String fundTransfer(FundTransferEntity fundTransfer) {
		// TODO Auto-generated method stub
		
		Account accOne = this.getAccount(fundTransfer.getFromAccount());
		Account accTwo = this.getAccount(fundTransfer.getToAccount());
		
		if(accOne == null || accTwo==null || accOne==accTwo) {
		return "ID MISMATCH";
		}
		

		double balance1 = accOne.getBalance();
		double balance2 = accTwo.getBalance();
		
		double amount = fundTransfer.getAmount();
		
		if(balance1 < amount || amount < 0) {
			return  "INSUFFICIENT FUNDS";
		}
		
		accTwo.setBalance(balance2+ amount);
		accountRepository.save(accTwo);
		accOne.setBalance(balance1 - amount);
		accountRepository.save(accOne);
		
		return "SUCCESS";
	}
	
	
	
	
}
