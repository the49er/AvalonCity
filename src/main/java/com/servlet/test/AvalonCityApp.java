package com.servlet.test;

import com.servlet.test.feature.storage.DataBaseInitService;
import com.servlet.test.feature.storage.Storage;
import com.servlet.test.feature.storage.StorageTemp;

import java.sql.Connection;
import java.util.Scanner;

public class AvalonCityApp {
    public static void main(String[] args) {

        String companiesJsonFileIn = "files/in/companies.json"; //companies
        String developersJsonFileIn = "files/in/developers.json"; // developers
        String projectsJsonFileIn = "files/in/projects.json"; // projects
        String customersJsonFileIn = "files/in/customers.json"; // customers
        String skillsJsonFileIn = "files/in/skills.json"; // skills
        String compCustomerKeysJsonFileIn = "files/in/company_customer_keys.json"; // company_customer
        String devProjectKeysJsonFileIn = "files/in/developer_project_keys.json"; // developer_project
        String devSkillKeysJsonFileIn = "files/in/developer_skill_keys.json"; // developer_skill

        //input URL, USER and PASSWORD from your DataBase
        String connectionUrl = "jdbc:mysql://localhost:3306/";
        String connectionUser = "root";
        System.out.println("Input password for user: " + connectionUser + "\r");
        String connectionUserPassword = new Scanner(System.in).nextLine();
        String pathToFile = "sql/initDB.sql";

        StorageTemp storageTemp = new StorageTemp(connectionUrl, connectionUser,
                connectionUserPassword, pathToFile);
        storageTemp.executeUpdates();


        //DataBaseInitialisation with test_user
        Storage storage = Storage.getInstance();
        Connection connection = storage.getConnection();
        new DataBaseInitService().initDbFlyWay(storage);

    }
}
