package com.aeroparker.db.dao;

import com.aeroparker.db.entity.customer.Customer;
import com.aeroparker.exception.NoSuchTitleException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


public class CustomerDAO implements CrudEntityDAO<Customer> {
    private static final String TABLE_NAME = "`aeroparker`.customers";
    private PreparedStatement insertSt;
    private PreparedStatement getMaxIdSt;

    public CustomerDAO(Connection connection) {
        try {
            insertSt = connection.prepareStatement(
                    "INSERT INTO " + TABLE_NAME + " (email, title, registered," +
                            " firstName, lastName, addressLine1, addressLine2, city," +
                            " postcode, telNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            getMaxIdSt = connection.prepareStatement(
                    "SELECT max(id) AS maxId FROM " + TABLE_NAME
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String insertNewEntity(Customer customer) {
        String message;
        try {
            insertSt.setString(1, customer.getEmail());
            insertSt.setString(2, customer.getTitle().getTitleValue());
            insertSt.setDate(3, customer.getRegistered());
            insertSt.setString(4, customer.getFirstName());
            insertSt.setString(5, customer.getLastName());
            insertSt.setString(6, customer.getAddressLine1());
            insertSt.setString(7, customer.getAddressLine2());
            insertSt.setString(8, customer.getCity());
            insertSt.setString(9, customer.getPostcode());
            insertSt.setString(10, customer.getTelNumber());

            insertSt.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException exception) {
            exception.printStackTrace();
            message = "Customer with email " + customer.getEmail() + " already exists";
            return message;

        }catch (NoSuchTitleException exception) {
            exception.getMessage();
            message = "no such title " + customer.getTitle().getTitleValue();
            return message;

        } catch (NullPointerException | SQLException exception) {
            exception.printStackTrace();
            message = "Incorrect data";
            return message;
        }

        if (getMaxId() > 0) {
            message = "Dear " + customer.getFirstName() + " your registration was successful";

            return message;
        }
    return "Try again";
    }


    public int getMaxId() {
        int id = 0;
        try (ResultSet rs = getMaxIdSt.executeQuery()) {
            while (rs.next()) {
                id = rs.getInt("maxId");
            }
            return id;

        } catch (NullPointerException | SQLException e) {
            return -1;
        }
    }
}