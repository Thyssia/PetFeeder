package ca.algonquin.petfeeder.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	// Database Schema
	// DATABASE name: petfeeder;
	// Username: root;
	// Password: root;

	    public static Connection getConnectionToDatabase() {
	        Connection connection = null;

	        System.out.println("getConnectionToDatabase.");

	        try {
	            // load the driver class
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("MySQL JDBC Driver Registered!");

	            // get hold of the DriverManager
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petfeeder?useSSL=false", "root", "root");

	        } catch (ClassNotFoundException e) {
	            System.out.println("MySQL JDBC Driver missing");
	            e.printStackTrace();
	        }

	        catch (SQLException e) {
	            System.out.println("Connection Failed! Check output console");
	            e.printStackTrace();
	        }

	        if (connection != null) {
	            System.out.println("Connection made to DB!");
	        }

	        return connection;
	    }
	}
