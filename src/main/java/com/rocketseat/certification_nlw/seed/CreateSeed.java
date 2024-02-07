package com.rocketseat.certification_nlw.seed;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateSeed {

    private final JdbcTemplate jdbcTemplate;

    public CreateSeed(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/pg_nlw");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        CreateSeed createSeed = new CreateSeed(dataSource);
        createSeed.run();
    }

    public void run(String... args) {
        executeSQLFile();
    }

    private void executeSQLFile() {
        try {
            String sqlScript = new String(Files.readAllBytes(Paths.get("src/main/resources/create.sql")));
            jdbcTemplate.execute(sqlScript);

            System.out.println("Seed created successfully");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }

}
