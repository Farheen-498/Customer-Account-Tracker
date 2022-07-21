package farheen.foundation.bank.service;

import java.util.List;

import farheen.foundation.bank.entities.Account;
import farheen.foundation.bank.entities.Customer;

public interface CustomerService {

	public Customer getCustomer(int customerId);
	public List<Customer> getCustomer();
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(int customerId, Customer customer);
	public Customer deleteCustomer(int customerId);
	public Account addAccountForCustomer(int customerId, Account account);
}
