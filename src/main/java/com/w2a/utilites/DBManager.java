package com.w2a.utilites;

import com.w2a.utilites.TestConfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

    public static Connection con = null;

    public static void setMySqlDBConnection() {
        try {
            Class.forName(TestConfig.mysqldriver);
            con = DriverManager.getConnection(TestConfig.mysqlurl,TestConfig.mysqluserName,TestConfig.mysqlpassword);
            if(!con.isClosed()){
                System.out.println("Connected to DB");
            }
        } catch (Exception e) {
            System.out.println("Error while connecting to DB");
            throw new RuntimeException(e);
        }
    }
    }
