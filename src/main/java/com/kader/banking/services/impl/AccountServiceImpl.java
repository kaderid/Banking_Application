package com.kader.banking.services.impl;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository repository;
    private final ObjectsValidator<AccountDto> validator;

    @Override
    public int save(UserDto dto){
        /*if(dto.getId() != null){
            throw new OperationNonPermittedException(
                    "Account cannot be updated",
                    "Save account",
                    "Account",
                    "Updated not permitted"
            );
        }*/
        validator.validate(dto);
        Account account = AccountDto.toEntity(dto);
        if(dto.getId() == null){
            account.setIban(generateRandomIban());
        }
        return repository.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll(){
        return repository.findAll()
                .stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto findById(int id){
        return repository.findById(id)
                .map(AccountDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No account was found with the provided ID : " + id));
    }

    @Override
    public void delete(int id){

        return repository.deleteById(id);
    }

    private String generateRandomIban(){
        Iban iban = Iban.random(CountryCode.DE).toFormattedString();
        boolean IbanExists = repository.findByIban(iban).isPresent();
        if(ibanExists){
            generateRandomIban;
        }
        return iban

    }
}
