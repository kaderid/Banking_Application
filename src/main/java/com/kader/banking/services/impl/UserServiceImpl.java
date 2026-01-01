package com.kader.banking.services.impl;

import com.kader.banking.dto.AccountDto;
import com.kader.banking.dto.UserDto;
import com.kader.banking.models.User;
import com.kader.banking.repositories.UserRepository;
import com.kader.banking.services.AccountService;
import com.kader.banking.services.UserService;
import com.kader.banking.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final AccountService accountService;
    private final ObjectsValidator<UserDto> validator;

    @Override
    public Integer save(UserDto dto){
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

         repository.deleteById(id);
    }

    @Override
    @Transactional
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
        return user.getId();
    }
}
