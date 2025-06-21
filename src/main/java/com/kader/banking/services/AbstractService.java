package com.kader.banking.services;

public interface AbstractService<T> {

    Integer save(T dto);
    List<T> findAll();
    T findbyId(Integer id);
    void delete(Integer id);
}
