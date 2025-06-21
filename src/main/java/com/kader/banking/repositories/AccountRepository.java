package com.kader.banking.repositories;

public interface AccountRepository extends JpaRepository<Account, int>{
    Optional<Account> findByIban(String iban);
}
