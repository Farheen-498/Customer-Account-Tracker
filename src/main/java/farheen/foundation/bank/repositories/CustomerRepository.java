package farheen.foundation.bank.repositories;

import org.springframework.data.repository.CrudRepository;

import farheen.foundation.bank.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	
}
