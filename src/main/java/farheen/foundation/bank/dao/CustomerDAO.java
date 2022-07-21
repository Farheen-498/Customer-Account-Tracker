package farheen.foundation.bank.dao;

import java.util.List;


import farheen.foundation.bank.entities.Customer;

public interface CustomerDAO {

	public Customer getCustomer(int customerId);
	public List<Customer> getCustomers();
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(int customerId, Customer customer);
	public Customer deleteCustomer(int customerId);
	
}
