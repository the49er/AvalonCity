package com.servlet.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class StringJoinerTest {
    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date.toLocalDate().atStartOfDay());
        System.out.println(date);


    }
}
