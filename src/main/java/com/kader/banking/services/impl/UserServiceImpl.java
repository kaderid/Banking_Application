package com.kader.banking.services.impl;

@Service
@RequiredArgsConstructor
public class UserServiceImpl UserService{

    private final UserRepository repository;
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
}
