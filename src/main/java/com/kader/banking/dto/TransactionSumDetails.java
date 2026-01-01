package com.kader.banking.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface TransactionSumDetails {

     LocalDate getTransactionDate();
     BigDecimal getAmount();
}

