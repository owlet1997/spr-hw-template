package org.example.connector.xml;

import lombok.Getter;
import org.hsqldb.jdbc.JDBCDataSource;

import javax.sql.DataSource;

@Getter
public class XmlHSQLConnector {
    private final String login;
    private final String password;
    private final DataSource dataSource;

    public XmlHSQLConnector(String login, String password) {
        this.login = login;
        this.password = password;
        this.dataSource = activateDS(login, password);
    }

    private DataSource activateDS(String login, String password){
        JDBCDataSource dataSource = new JDBCDataSource();
        dataSource.setDatabase("jdbc:hsqldb:mem:demo");
        dataSource.setUser(login);
        dataSource.setPassword(password);
        return dataSource;
    }
}
