package org.example.connector.programmatic;

import lombok.Getter;

import javax.sql.DataSource;

import static org.example.connector.utils.Utils.activateDS;

@Getter
public class ProgrammaticHSQLConnector {
    private final String login;
    private final String password;
    private final DataSource dataSource;

    public ProgrammaticHSQLConnector(String login, String password) {
        this.login = login;
        this.password = password;
        this.dataSource = activateDS(login, password);
    }

}
