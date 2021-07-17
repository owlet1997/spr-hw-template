package org.example.connector.java;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.connector.utils.Utils;

import javax.sql.DataSource;

@Getter
@AllArgsConstructor
public class JavaHSQLConnector {
    private final DataSource dataSource;
}
