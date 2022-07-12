package com.aeroparker.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
    public static void main(String[] args) {

        try (OutputStream outputStream = new FileOutputStream("src/main/resources/db.properties")) {
            Properties properties = new Properties();
            properties.put("dbUrl", "jdbc:mysql://localhost:3306/aeroparker");
            properties.put("dbUserTest", "test_user");
            properties.put("dbUserTest_pass", "password");
            properties.put("dbDriver", "com.mysql.cj.jdbc.Driver");

            properties.store(outputStream, null);
            System.out.println(properties);
        }catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
