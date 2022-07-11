package com.servlet.test.db.entity.customer;

import com.servlet.test.db.dao.CustomerDAO;
import com.servlet.test.feature.storage.Storage;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

public class CustomTest {
    public static void main(String[] args) {
        String title = CustomerTitle.MR.getTitleValue();
        System.out.println(title);

        System.out.println(CustomerTitle.getMsgForException());
        System.out.println(CustomerTitle.getEnumFromString("Ms"));
        Customer customer = new Customer();
        customer.setRegistered(Date.valueOf(LocalDate.now()));
        customer.setFirstName("Oleg");
        customer.setLastName("Popov");
        customer.setEmail("000@ukr.net");
        customer.setTitle(CustomerTitle.MR);

        Storage storage = Storage.getInstance();

        Connection connection = storage.getConnection();
        CustomerDAO customerDAO = new CustomerDAO(connection);

        System.out.println(customerDAO.insertNewEntity(customer));
    }
}
