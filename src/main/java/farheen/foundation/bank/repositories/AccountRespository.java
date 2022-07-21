package farheen.foundation.bank.repositories;

import org.springframework.data.repository.CrudRepository;

import farheen.foundation.bank.entities.Account;

public interface AccountRespository extends CrudRepository<Account, Integer> {

}
