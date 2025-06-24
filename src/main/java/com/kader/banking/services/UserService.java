package com.kader.banking.services;

public interface UserService extends AbstractService<UserDto>{

    Integer validateAccount(Integer id);
    Integer invalidateAccount(Integer id);
}
