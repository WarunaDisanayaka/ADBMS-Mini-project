package com.hostal.hostal.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

@RestController
@RequestMapping("/complains")
public class ComplainsCountController {


    @PostMapping("/openCount")
    public int getOpenComplainsCount() {
        int openCount = 0;

        // Call the stored procedure to get the count of complaints in progress
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://hostal.cut49epaxhw7.us-east-1.rds.amazonaws.com:3306/hostal", "admin", "waruna99")) {
            CallableStatement callableStatement = connection.prepareCall("{call GetOpenComplainsCount()}");
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                openCount = resultSet.getInt("open_complains_count");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions that might occur during database interaction
        }

        return openCount;
    }


    @PostMapping("/inProgressCount")
    public int getInProgressComplainsCount() {
        int inProgressCount = 0;

        // Call the stored procedure to get the count of complaints in progress
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://hostal.cut49epaxhw7.us-east-1.rds.amazonaws.com:3306/hostal", "admin", "waruna99")) {
            CallableStatement callableStatement = connection.prepareCall("{call GetInprogressComplainsCount()}");
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                inProgressCount = resultSet.getInt("inprogress_complains_count");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions that might occur during database interaction
        }

        return inProgressCount;
    }


    @PostMapping("/closedCount")
    public int getClosedComplainsCount() {
        int closedCount = 0;

        // Call the stored procedure to get the count of complaints in progress
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://hostal.cut49epaxhw7.us-east-1.rds.amazonaws.com:3306/hostal", "admin", "waruna99")) {
            CallableStatement callableStatement = connection.prepareCall("{call GetClosedComplainsCount()}");
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                closedCount = resultSet.getInt("close_complains_count");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions that might occur during database interaction
        }

        return closedCount;
    }



    @PostMapping("/repairCount")
    public int getRepairComplainsCount() {
        int repairCount = 0;

        // Call the stored procedure to get the count of complaints in progress
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://hostal.cut49epaxhw7.us-east-1.rds.amazonaws.com:3306/hostal", "admin", "waruna99")) {
            CallableStatement callableStatement = connection.prepareCall("{call GetRepairComplainsCount()}");
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                repairCount = resultSet.getInt("repair_complains_count");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions that might occur during database interaction
        }

        return repairCount;
    }


}
