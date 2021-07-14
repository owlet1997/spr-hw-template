package org.example.connector.java;

import lombok.Getter;
import org.example.connector.utils.Utils;

import javax.sql.DataSource;

@Getter
public class JavaHSQLConnector {
    private final String login;
    private final String password;
    private final DataSource dataSource;

    public JavaHSQLConnector(String login, String password) {
        this.login = login;
        this.password = password;
        this.dataSource = Utils.activateDS(login, password);
    }

}
