package com.kader.banking.services.impl;

@Service
@RequiredArgsConstructor
public class UserServiceImpl UserService{

    private final UserRepository repository;
    private final ObjectsValidator<UserDto> validator;

    @Override
    public int save(){
        return null;
    }

    @Override
    public List<UserDto> findAll(){
        return null;
    }

    @Override
    public UserDto findById(int id){
        return null;
    }

    @Override
    public void delete(int id){
        return null;
    }
}
