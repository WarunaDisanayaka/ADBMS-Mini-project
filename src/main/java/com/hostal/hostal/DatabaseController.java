package com.hostal.hostal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DatabaseController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/check-database")
    public String checkDatabase() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            // Perform a simple database query to check if the database is responsive
            ResultSet resultSet = statement.executeQuery("SELECT 1");
            if (resultSet.next()) {
                return "Database is working!";
            } else {
                return "Database query returned no results.";
            }

        } catch (SQLException e) {
            // Handle any exceptions that may occur during the database check
            return "Error while checking the database: " + e.getMessage();
        }
    }

    @GetMapping("/list-databases")
    public String listDatabases() {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getCatalogs();

            List<String> databases = new ArrayList<>();
            while (resultSet.next()) {
                String databaseName = resultSet.getString("TABLE_CAT");
                databases.add(databaseName);
            }

            if (!databases.isEmpty()) {
                return "List of databases: " + String.join(", ", databases);
            } else {
                return "No databases found.";
            }

        } catch (SQLException e) {
            // Handle any exceptions that may occur during the database check
            return "Error while listing databases: " + e.getMessage();
        }
    }
}
