package farheen.foundation.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import farheen.foundation.bank.entities.Account;
import farheen.foundation.bank.entities.Customer;
import farheen.foundation.bank.repositories.AccountRespository;
import farheen.foundation.bank.repositories.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRespository accountRepository;
	
	@Override
	public Customer getCustomer(int customerId) {
		Optional<Customer> findById = customerRepository.findById(customerId);
		Customer customer = findById.get();
		System.out.println(customer);
		
		return customer;
	}

	@Override
	public List<Customer> getCustomer() {
		List<Customer> customers =(List<Customer>) customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer createCustomer(Customer customer) {
           return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(int customerId, Customer customer) {
		Customer updateCustomer = null;
		Optional<Customer> findById = customerRepository.findById(customerId);
		if(findById.isPresent()) {
			updateCustomer.setFirstName(customer.getFirstName());
			updateCustomer.setLastName(customer.getLastName());
			updateCustomer.setEmail(customer.getEmail());
			customerRepository.save(updateCustomer);
		}
		return updateCustomer;
	}

	@Override
	public Customer deleteCustomer(int customerId) {
		Customer deleteCustomer = null;
		Optional<Customer> findById= customerRepository.findById(customerId);
		if(findById.isPresent()) {
			deleteCustomer = findById.get();
			if(deleteCustomer !=null) {
				customerRepository.delete(deleteCustomer);
			}
		}
		return deleteCustomer;
	}

	

	@Override
	public Account addAccountForCustomer(int customerId, Account account) {
		Customer cust = customerRepository.findById(customerId).get();
		if(cust != null) {
			cust.getAccounts().add(account);
			accountRepository.save(account);
			customerRepository.save(cust);
			return account;
		}
		return null;
	}

	
}
