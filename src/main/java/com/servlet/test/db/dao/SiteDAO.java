package com.servlet.test.db.dao;

import com.servlet.test.db.entity.site.Site;
import com.servlet.test.exception.NoSuchTitleException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


public class SiteDAO implements CrudEntityDAO<Site> {
    private static final String TABLE_NAME = "`aeroparker`.sites";
    private PreparedStatement insertSt;
    private PreparedStatement getMaxIdSt;

    public SiteDAO(Connection connection) {
        try {
            insertSt = connection.prepareStatement(
                    "INSERT INTO " + TABLE_NAME + " (name) VALUES (?)"
            );

            getMaxIdSt = connection.prepareStatement(
                    "SELECT max(id) AS maxId FROM " + TABLE_NAME
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String insertNewEntity(Site site) {
        try {
            insertSt.setString(1, site.getName());
            insertSt.executeUpdate();

        } catch (NullPointerException | SQLException exception) {
            exception.printStackTrace();
            return "Incorrect Data";

        } catch (NoSuchTitleException exception) {
            exception.getMessage();
            return "Incorrect Data";

        }
        return "Incorrect Data";
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