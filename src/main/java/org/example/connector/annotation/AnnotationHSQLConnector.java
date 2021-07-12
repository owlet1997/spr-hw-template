package org.example.connector.annotation;

import lombok.Getter;
import org.hsqldb.jdbc.JDBCDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Getter
public class AnnotationHSQLConnector {
    private final String login;
    private final String password;
    private final DataSource dataSource;

    public AnnotationHSQLConnector(@Value("${login}") String login, @Value("${password}") String password) {
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
