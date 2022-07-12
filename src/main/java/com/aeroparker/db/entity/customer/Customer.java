package com.aeroparker.db.entity.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.sql.Date;


@Data
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Customer {
    private int id;
    private Date registered;
    private String email;
    private CustomerTitle title;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postcode;
    private String telNumber;


}
