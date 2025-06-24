package com.kader.banking.repositories;

public interface UserRepository extends JpaRepository<User, Integer>{

    List<User> findAllByFirstname(String firstname);

    List<User> findAllByFirstnameContaining(String firstname);

    List<User> findAllByFirstnameContainingIgnoreCase(String firstname);

    List<User> findAllByAccountIban(String iban);

    User findByFirstnameContainingIgnoreCaseAndEmail(String firstname, String email);

    @Query("from user where firstname = :fn")
    List<User> searchByFirstname(@Param("fn") String firstname);

    @Query("from user where firstname = '%:firstname%'")
    List<User> searchByFirstname(String firstname);

    @Query("from user u inner join Account a on u.id = a.user.id where a.iban = :iban")
    List<User> searchByIban(String iban);

    @Query(value = "select * from _user u inner join Account a on u.id = a.user.id and a.iban = :iban", nativeQuery = true)
    List<User> searchByIbanNative(String iban);




}
