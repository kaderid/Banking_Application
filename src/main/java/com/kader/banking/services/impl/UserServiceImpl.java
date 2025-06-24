package com.kader.banking.services.impl;

@Service
@RequiredArgsConstructor
public class UserServiceImpl UserService{

    private final UserRepository repository;
    private final AccountService accountService;
    private final ObjectsValidator<UserDto> validator;

    @Override
    public int save(UserDto dto){
        validator.validate(dto);
        User user = UserDto.toEntity(dto);
        return repository.save(user).getId();
    }

    @Override
    public List<UserDto> findAll(){
        return repository.findAll()
                .stream()
                .map(UserDto::fromEntity)
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

    @Override
    public Integer validateAccount(Integer id){
        User user = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No user was found for account validation"));
        user.setActive(true);
        AccountDto account = AccountDto.builder()
                .user(UserDto.fromEntity(user))
                .build();
        accountService.save(account);
        return user.getId();
    }

    @Override
    public Integer invalidateAccount(Integer id){
        User user = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No user was found for account validation"));
        user.setActive(false);
        return repository.deleteById(id);
    }
}
