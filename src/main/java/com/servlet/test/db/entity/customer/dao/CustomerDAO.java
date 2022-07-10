package com.servlet.test.db.entity.customer.dao;

import com.servlet.test.db.entity.customer.Customer;
import lombok.extern.slf4j.Slf4j;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerDAO {
    private static final String TABLE_NAME = "'aeroparker'.customers";
    private PreparedStatement insertSt;
    private PreparedStatement getMaxIdSt;

    public CustomerDAO(Connection connection){
        try {
            insertSt = connection.prepareStatement(
                    "INSERT INTO " + TABLE_NAME + " (name, age, gender, " +
                            "salary, company_id) VALUES (?, ?, ?, ?, ?)"
            );

            getMaxIdSt = connection.prepareStatement(
                    "SELECT max(id) AS maxId FROM " + TABLE_NAME
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long insertNewEntity(Customer customer) {
        long id = 0;
        try {
            insertSt.setLong(1, customer.getId());
            insertSt.setDate(2, customer.getRegistered());
            insertSt.setString(3, customer.getFirstName());
            insertSt.setString(4, customer.getLastName());
            insertSt.setString(5, customer.getEmail());
            insertSt.setString(6, customer.getTitle().getTitle());
            insertSt.executeUpdate();

        } catch (JdbcSQLIntegrityConstraintViolationException exception) {
            System.out.println("Null not allowed");
            return -1;
        } catch (NullPointerException | SQLException exception) {
            System.out.println("Customer was not created");
            return -1;
        }

        try (ResultSet rs = getMaxIdSt.executeQuery()) {
            while (rs.next()) {
                id = rs.getLong("maxId");
            }
            return id;
        } catch (NullPointerException | SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }
}
