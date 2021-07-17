package org.example.connector.annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.connector.utils.Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Getter
@AllArgsConstructor
public class AnnotationHSQLConnector {
    private final DataSource dataSource;

}
