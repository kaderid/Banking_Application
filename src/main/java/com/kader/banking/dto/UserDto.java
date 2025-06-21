package com.kader.banking.dto;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {

    private int id;
    @NotNull
    @NotEmpty
    @NotBlank
    private String firstname;

    @NotNull(message = "{common.user.error.empty}")
    @NotEmpty(message = "Le prénom ne doit pas etre vide")
    @NotBlank(message = "Le prénom ne doit pas etre vide")
    private String lastname;

    @NotNull
    @NotEmpty
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min= 8, max = 16)
    private String password;

    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build;
    }

    public static User toEntity(UserDto user){
        return User.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build;
    }
}
