package com.kader.banking.repositories;

public interface TransactionRepository  extends JpaRepository<Transaction, Integer>{

    List<Transaction> findAllByUserId(Integer id);
}
