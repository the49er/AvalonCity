import com.aeroparker.feature.storage.StorageTemp;
import com.aeroparker.feature.storage.DataBaseInitService;
import com.aeroparker.feature.storage.Storage;

import java.sql.Connection;
import java.util.Scanner;

public class AvalonCityApp {
    public static void main(String[] args) {


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
