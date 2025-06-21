package com.kader.banking.dto;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class AddressDto {

    private int id;
    private String street;
    private int houseNumber;
    private int zipCode;
    private String city;
    private String country;
    private int userId;

    public static AddressDto fromEntity(Address address){
        return addressDto.builder()
                .id(address.getId())
                .street(address.getStreet())
                .houseNumber(adress.getHouseNumber())
                .zipcode(address.getZipCode())
                .city(address.getCity())
                .country(address.getCountry())
                .userId(address.getUser().getId())
                .build()
    }

    public static Address toEntity(AddressDto address){
        return address.builder()
                .id(address.getId())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .zipcode(address.getZipCode())
                .city(address.getCity())
                .country(address.getCountry())
                .user(
                        User.builder()
                                .id(address.getUserId())
                                .build
                )
                .build()
    }
}
