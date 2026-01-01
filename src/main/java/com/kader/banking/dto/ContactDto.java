package com.kader.banking.dto;

import com.kader.banking.models.Contact;
import com.kader.banking.models.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ContactDto {

    private Integer id;

    private String firstname;
    private String lastname;
    private String email;
    private String iban;
    private Integer userId;

    public static ContactDto fromEntity(Contact contact){
        return ContactDto.builder()
                .id(contact.getId())
                .firstname(contact.getFirstname())
                .lastname(contact.getLastname())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .userId(contact.getUser().getId())
                .build();
    }

    public static Contact toEntity(ContactDto contact){
        return Contact.builder()
                .id(contact.getId())
                .firstname(contact.getFirstname())
                .lastname(contact.getLastname())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .user(
                        User.builder()
                                .id(contact.getUserId())
                                .build()
        )
                .build();
    }
}
