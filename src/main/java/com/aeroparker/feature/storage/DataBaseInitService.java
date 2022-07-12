package com.aeroparker.feature.storage;

import com.aeroparker.feature.prefs.Config;
import org.flywaydb.core.Flyway;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataBaseInitService {

    public void initDbFlyWay(Storage storage) {
        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            String connectionUrl = properties.getProperty("dbUrl");
            String connectionUser = properties.getProperty("dbUserTest");
            String connectionUserPassword = properties.getProperty("dbUserTest_pass");

            Flyway flyway = Flyway
                    .configure()
                    .dataSource(connectionUrl, connectionUser, connectionUserPassword)
                    .load();

            flyway.migrate();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
