package com.kader.banking.repositories;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

    List<Contact> findAllByUserId(Integer userId);
}
