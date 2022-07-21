package farheen.foundation.bank.entities;

import java.util.Set;

import javax.persistence.JoinColumn;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name= "customer_accounts",
			joinColumns = @JoinColumn(name = "customer_id"),
			inverseJoinColumns = @JoinColumn(name ="account_id")
			)
	private Set<Account> accounts;
	
	public Customer() {
		
	}
	
	public Customer(String firstName, String lastName, String email) {
		this.firstName= firstName;
		this.lastName=lastName;
		this.email=email;
		
	}
	
	public Customer(int customerId, String firstName, String lastName, String email) {
		this.customerId=customerId;
		this.firstName= firstName;
		this.lastName=lastName;
		this.email=email;
		
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", accounts=" + accounts + "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
}
