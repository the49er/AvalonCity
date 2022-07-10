package com.servlet.test.db.entity.customer;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.sql.Date;


@Data
@RequiredArgsConstructor
@ToString
public class Customer {
    private long id;
    private Date registered;
    private String firstName;
    private String lastName;
    private String email;
    private CustomerTitle title;
}
