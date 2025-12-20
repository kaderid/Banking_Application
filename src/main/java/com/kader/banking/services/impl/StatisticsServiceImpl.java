package com.kader.banking.services.impl;


import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService{

    private final TransactionRepository transactionRepository;

    @Override
    Map<LocalDate, BigDecimal> findSumTransactionsByDate(LocalDate startDate, LocalDate endDate, Integer userId){
        LocalDateTime start = LocalDateTime.of(startDate, LocalTime.of(0, 0, 0));
        LocalDateTime end = LocalDateTime.of(endDate, LocalTime.of(23, 59, 59));
        return transactionRepository.findSumTransactionsByDate(start, end, userId);

    };

    @Override
    BigDecimal getAccountBalance(Integer userId){
        return transactionRepository.findAccountBalance(userId);
    };

    @Override
    BigDecimal highestTransfert(Integer userId){
        return transactionRepository.findHighestAmountByTransactionType(userId, TransactionType)
    };

    @Override
    BigDecimal highestDeposit(Integer userId){
        return transactionRepository.findHighestAmountByTransactionType(userId, TransactionType.DEPOSIT)

    };
}
