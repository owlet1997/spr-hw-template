package org.example.connector.annotation;

import lombok.Getter;
import org.example.connector.utils.Utils;
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
        this.dataSource = Utils.activateDS(login, password);
    }

}
