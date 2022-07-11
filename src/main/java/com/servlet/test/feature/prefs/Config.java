package com.servlet.test.feature.prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Config {

    public static final String DB_JDBC_CONNECTION_URL = "dbUrl";
    public static final String DB_JDBC_USER_1 = "dbUserTest";
    public static final String DB_JDBC_USER_PASSWORD_1 = "dbUserTest_pass";
    public static final String DB_DRIVER = "db_driver";
    public static final String DEFAULT_PREFS_FILENAME = "C:/Java_GoIt/JavaDev/SERVLETS/testServ/src/main/resources/json/prefs.json";
    private Map<String, Object> prefs = new HashMap<>();

    public Config() {
        this(DEFAULT_PREFS_FILENAME);
    }

    public Config(String filename) {
        try {
            String json = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(filename))
            );

            TypeToken<?> typeToken = TypeToken.getParameterized(
                    Map.class,
                    String.class,
                    Object.class
            );
            prefs = new Gson().fromJson(json, typeToken.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getString(String key) {
        return getPref(key).toString();
    }

    public Object getPref(String key) {
        return prefs.get(key);
    }


}
