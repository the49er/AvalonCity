package com.servlet.test.db.entity.customer;

public class CustomTest {
    public static void main(String[] args) {
        String title = CustomerTitle.MR.getTitle();
        System.out.println(title);

        System.out.println(CustomerTitle.getMsgForException());
        System.out.println(CustomerTitle.getEnumFromString("Ms"));
    }
}
