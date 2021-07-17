package org.example.connector.programmatic;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.sql.DataSource;

import static org.example.connector.utils.Utils.activateDS;

@Getter
@AllArgsConstructor
public class ProgrammaticHSQLConnector {
    private final DataSource dataSource;

}
