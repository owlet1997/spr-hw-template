package org.example.config.javaconf;

import org.example.connector.java.JavaHSQLConnector;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        final PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocations(new ClassPathResource("db.properties"));
        return configurer;
    }

    @Bean
    public JavaHSQLConnector connectionPool(@Value("${login}") String login, @Value("${password}") String password) {
        return new JavaHSQLConnector(login, password);
    }

    @Bean
    public UserService userService(UserRepository repository) {
        return new UserService(repository);
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

}
