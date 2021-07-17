package org.example.connector.annotation;

import org.hsqldb.jdbc.JDBCDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExtDataSourceBean extends JDBCDataSource {

    public ExtDataSourceBean(@Value("${url}") String url,
                             @Value("${login}")  String login,
                             @Value("${password}")  String password){
        super.setDatabase(url);
        super.setUser(login);
        super.setPassword(password);
    }
}
