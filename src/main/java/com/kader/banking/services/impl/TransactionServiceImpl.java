package com.kader.banking.services.impl;


@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository repository;
    private final ObjectsValidator<TransactionDto> validator;

    @Override
    public Integer save(TransactionDto dto){
        validator.validate(dto);
        Transaction transaction = TransactionDto.toEntity(dto);
        BigDecimal transactionMultiplier = BigDecimal.valueOf(getTransactionMultiplier(transaction.getType()));
        BigDecimal amount = transaction.getAmount().multiply(transactionMultiplier);
        transaction.setAmount(amount);
        return repository.save(transaction).getId();
    }

    @Override
    public List<TransactionDto> findAll(){
        return repository.findAll()
                .stream()
                .map(TransactionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id){
        return repository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No user was found with the provided ID : " + id));
    }

    @Override
    public void delete(Integer id){

        return repository.deleteById(id);
    }

    private int transactionType(TransactionType type){
        return TransactionType.TRANSFERT == type ? -1 : 1;
    }

    @Override
    public List<TransactionDto> findAllByUserId (Integer UserId){

        return repository.findAllByUserId(id)
                .stream()
                .map(TransactionDto::fromEntity)
                .collect(Collectors.toList());
    }
}
