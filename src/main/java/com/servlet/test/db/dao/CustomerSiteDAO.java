
package com.servlet.test.db.dao;
        import com.servlet.test.db.entity_relation.CustomerSiteKey;
        import com.servlet.test.exception.NoSuchTitleException;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.SQLException;
        import java.sql.SQLIntegrityConstraintViolationException;


public class CustomerSiteDAO implements CrudEntityDAO<CustomerSiteKey> {
    private static final String TABLE_NAME = "`aeroparker`.customer_site";
    private PreparedStatement insertSt;

    public CustomerSiteDAO(Connection connection) {
        try {
            insertSt = connection.prepareStatement(
                    "INSERT INTO " + TABLE_NAME + " (customer_id, site_id) VALUES (?, ?)"
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String insertNewEntity(CustomerSiteKey customerSiteKey) {
        try {
            insertSt.setInt(1, customerSiteKey.getCustomerId());
            insertSt.setInt(2, customerSiteKey.getSiteId());
            insertSt.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException exception) {
            exception.printStackTrace();
            return "Incorrect Data";

        } catch (NoSuchTitleException exception) {
            exception.getMessage();
            return "Incorrect Data";

        } catch (NullPointerException | SQLException exception) {
            exception.printStackTrace();
            return "Incorrect Data";
        }
        return "Incorrect Data";
    }
}