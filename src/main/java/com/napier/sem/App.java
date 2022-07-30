package com.napier.sem;
import java.sql.*;

public class App {
    // Database driver path
    static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    // Connection to MySQL database
    public static Connection connection;

    public static void main(String[] args) throws SQLException {
        // Connect to database
        if (args.length < 1)
        {
            connection = connect("localhost:33061", DATABASE_DRIVER, false);
        }
        else
        {
            connection = connect(args[0], DATABASE_DRIVER, false);
        }

        // Create an object of the queries class
        Queries queries = new Queries(connection);

        // Queries

        System.out.println("All the countries in the world organised by largest population to smallest.");
        queries.query1();

        // System.out.println("All the countries in a continent organised by largest population to smallest.");
        // queries.query2("Europe");

        // System.out.println("All the countries in a region organised by largest population to smallest.");
        // queries.query3("Caribbean");

        // System.out.println("The top N populated countries in the world where N is provided by the user.");
        // queries.query4(10);

        // System.out.println("The top N populated countries in a continent where N is provided by the user.");
        // queries.query5(10, "Europe");

        // System.out.println("The top N populated countries in a region where N is provided by the user.");
        // queries.query6(10, "Caribbean");

        // System.out.println("All the cities in the world organised by largest population to smallest.");
        // queries.query7();

        // System.out.println("All the cities in a continent organised by largest population to smallest.");
        // queries.query8("South America");

        // System.out.println("All the cities in a region organised by largest population to smallest.");
        // queries.query9("Central Africa");

        // System.out.println("All the cities in a country organised by largest population to smallest.");
        // queries.query10("United Kingdom");

        // System.out.println("All the cities in a district organised by largest population to smallest.");
        // queries.query11("Scotland");
}

public static Connection connect(String location, String databaseDriver, boolean isTest) {
    try {
            // Load Database driver
            Class.forName(databaseDriver);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            return null;
        }

        int retries = 60;
        for (int i = 1; i <= retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                if (location == null) { return null; }

                // Connect to database
                Connection connection = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root",
                        "example");
                System.out.println("Successfully connected");
                return connection;
            }
            catch (SQLException e) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(e.getMessage());
            }
            if (!isTest) {
                try {
                    // Wait a bit before the next retry
                    Thread.sleep(2000);
                }
                catch (InterruptedException ie) {
                    System.out.println(ie.getMessage());
                }
            }
        }
        return null;
    }
}