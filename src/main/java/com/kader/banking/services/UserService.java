package com.kader.banking.services;

import com.kader.banking.dto.UserDto;

public interface UserService extends AbstractService<UserDto>{

    Integer validateAccount(Integer id);
    Integer invalidateAccount(Integer id);
}
