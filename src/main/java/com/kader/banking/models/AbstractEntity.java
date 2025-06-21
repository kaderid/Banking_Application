package com.kader.banking.models;


@Data
@NoArgsConstructor
@SuperBuilder
@MappedSuperClass
@EntityListeners(AuditingEntityListeners.class)
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreatedDate
    @Column(
            name = 'createdDate'
            nullable = false,
            updatable = false
    )
    private localDateTime createdDate;

    @LastModifiedDate
    @Column(
            name = "lastModifiedDate"
    )
    private localDateTime lastModifiedDate;
}
