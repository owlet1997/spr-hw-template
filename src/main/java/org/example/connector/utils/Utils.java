package org.example.connector.utils;

import org.hsqldb.jdbc.JDBCDataSource;

import javax.sql.DataSource;

public class Utils {

    public static DataSource activateDS(String login, String password){
        JDBCDataSource dataSource = new JDBCDataSource();
        dataSource.setDatabase("jdbc:hsqldb:mem:demo");
        dataSource.setUser(login);
        dataSource.setPassword(password);
        return dataSource;
    }
}
