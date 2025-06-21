package com.kader.banking.dto;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class AccountDto {


    private int id;
    private String iban;
    private UserDto user;

    public static AccountDto fromEntity(Account account){
        return AccountDtobuilder()
                .id(account.getId())
                .iban(account.getIban())
                .user(userDto.fromEntity(account.getUser()))
                .build()
    }

    public static Account toEntity(AccountDto account){
        return Account.builder()
                .id(account.getId())
                .iban(account.getIban())
                .user(userDto.toEntity(account.getUser()))
                .build()
    }


}
