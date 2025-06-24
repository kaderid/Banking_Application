package com.kader.banking.services;

public interface ContactService extends AbstractService<ContactDto>{

    List<ContactDto> findAllByUserId(Integer, userId);
}
