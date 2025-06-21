package com.kader.banking.services;

public interface AbstractService<T> {

    int save(T dto);
    List<T> findAll();
    T findbyId(int id);
    void delete(int id);
}
