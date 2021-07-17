package org.example.connector.java.javaconf;

import org.example.connector.java.JavaHSQLConnector;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.hsqldb.jdbc.JDBCDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        final PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocations(new ClassPathResource("db.properties"));
        return configurer;
    }

    @Bean
    public DataSource dataSource(@Value("${url}") String url,
                                 @Value("${login}")  String login,
                                 @Value("${password}")  String password) {
        JDBCDataSource dataSource = new JDBCDataSource();
        dataSource.setDatabase(url);
        dataSource.setUser(login);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JavaHSQLConnector javaHSQLConnector(DataSource dataSource){
        return new JavaHSQLConnector(dataSource);
    }

}
