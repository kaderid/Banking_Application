package com.kader.banking.models;

import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

import lombok.experimental.SuperBuilder;


import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account extends AbstractEntity {

    private String iban;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
}
