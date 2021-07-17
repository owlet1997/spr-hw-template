package org.example.connector.annotation.config;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class AnnotationPropertySourcesConfigurer extends PropertySourcesPlaceholderConfigurer {
    public AnnotationPropertySourcesConfigurer() {
        setLocations(new ClassPathResource("db.properties"));
    }
}
