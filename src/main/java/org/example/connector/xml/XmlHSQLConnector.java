package org.example.connector.xml;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.sql.DataSource;

import static org.example.connector.utils.Utils.activateDS;

@Getter
@AllArgsConstructor
public class XmlHSQLConnector {
    private final DataSource dataSource;
}
