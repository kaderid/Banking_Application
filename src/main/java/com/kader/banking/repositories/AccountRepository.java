package com.kader.banking.repositories;

public interface AccountRepository extends JpaRepository<Account, Integer>{
    Optional<Account> findByIban(String iban);
    Optional<Account> findByUserId(Integer id);
}
