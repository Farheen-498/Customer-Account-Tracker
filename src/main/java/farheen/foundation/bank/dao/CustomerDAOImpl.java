package farheen.foundation.bank.dao;

import java.util.ArrayList;
import java.util.List;

import farheen.foundation.bank.entities.Account;
import farheen.foundation.bank.entities.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	private static List<Customer> customers = new ArrayList<Customer>();
	private static int counter=1000;
	static {
		customers.add(new Customer(++counter, "Farheen","Ali", "farheen.ali@xyz.com"));
		customers.add(new Customer(++counter, "Eliza","Beth", "eliza.beth@gmail.com"));
		customers.add(new Customer(++counter, "Muskan","sharma", "muskan.sharma@yahoo.com"));
		
	}
	
	@Override
	public Customer getCustomer(int customerId) {
		Customer searchCustomer =null;
		for(Customer customer :customers) {
			if(customer.getCustomerId()==customerId) {
				searchCustomer = customer;
				break;
			}
		}
		return searchCustomer;
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customers;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		Customer saveCustomer = customer;
		saveCustomer.setCustomerId(++counter);
		customers.add(saveCustomer);
		return saveCustomer;
	}

	@Override
	public Customer updateCustomer(int customerId, Customer customer) {
    Customer updateCustomer = null;
		
		for(Customer c: customers) {
			if(c.getCustomerId()==customerId) {
				c.setFirstName(customer.getFirstName());
				c.setLastName(customer.getLastName());
				c.setEmail(customer.getEmail());
				updateCustomer = c;
				break;
			}
		}
		return updateCustomer;
	}

	@Override
	public Customer deleteCustomer(int customerId) {
    Customer deleteCustomer = null;
		
		for(Customer customer: customers) {
			if(customer.getCustomerId()==customerId) {
				deleteCustomer = customer;
				customers.remove(deleteCustomer);
				break;
			}
		}
		return deleteCustomer;
	}

}
