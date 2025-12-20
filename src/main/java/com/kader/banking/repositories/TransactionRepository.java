package com.kader.banking.repositories;

import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

public interface TransactionRepository  extends JpaRepository<Transaction, Integer>{

    List<Transaction> findAllByUserId(Integer id);

    @Query("select sum(t.amount) from Transaction t where t.user.id = :userId")
    BigDecimal findAccountBalance(@Param("userId") Integer userId);

    @Query("select max(abs(t.amount)) as amount from Transaction t where t.user.id = :userId and t.type = :transactiontype")
    BigDecimal findHighestAmountByTransactionType( Integer userId, TransactionType transactionType);

    @Query("select t.createdDate, sum(t.amount) from Transaction t where t.user.id = :userId and t.createdDate between :start and :end group by t.createdDate")
    Map<LocalDate, BigDecimal> findSumTransactionsByDate(LocalDateTime start, LocalDateTime end, Integer userId);
}
}
