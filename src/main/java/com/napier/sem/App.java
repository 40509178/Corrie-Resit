package com.napier.sem;
import java.sql.*;
public class App {
    // Database driver path
    static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    // Connection to MySQL database
    public static Connection connection;
    public static void main(String[] args) {
        System.out.println("Hello world");
        // Connect to database
        if (args.length < 1)
        {
            connection = connect("localhost:33061", DATABASE_DRIVER, false);
        }
        else
        {
            connection = connect(args[0], DATABASE_DRIVER, false);
        }
// Create instance of the database access object
        DAO dao = new DAO(connection);
        System.out.println(dao.AllCountries());
}
    public static Connection connect(String location, String databaseDriver, boolean isTest)
    {
        try
        {
            // Load Database driver
            Class.forName(databaseDriver);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            return null;
        }

        int retries = 60;
        for (int i = 1; i <= retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                if (location == null) { return null; }

                // Connect to database
                Connection connection = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root",
                        "example");
                System.out.println("Successfully connected");
                return connection;
            }
            catch (SQLException e)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(e.getMessage());
            }
            if (!isTest)
            {
                try
                {
                    // Wait a bit before the next retry
                    Thread.sleep(5000);
                }
                catch (InterruptedException ie)
                {
                    System.out.println(ie.getMessage());
                }
            }
        }
        return null;
    }


}