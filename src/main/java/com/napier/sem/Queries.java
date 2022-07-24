package com.napier.sem;

import java.sql.*;

public class Queries {
    private final Connection connection;

    public Queries(Connection connection) {
        this.connection = connection;
    }

    public void query1() throws SQLException {
        // All the countries in the world organised by largest population to smallest.
        String queryString = "SELECT code, " + // build query
                "country.name, " +
                "continent, " +
                "region, " +
                "country.population, " +
                "city.name AS capital " +
                "FROM country " +
                "JOIN city ON country.capital = city.id " +
                "ORDER BY country.population DESC;";

        Statement statement = connection.createStatement(); // make statement to execute query
        ResultSet resultSet = statement.executeQuery(queryString); // execute query

        while (resultSet.next()) { // print all results from query
            String code = resultSet.getString("code");
            String name = resultSet.getString("name");
            String continent = resultSet.getString("continent");
            String region = resultSet.getString("region");
            Long population = resultSet.getLong("population");
            String capital = resultSet.getString("capital");

            // make string and print it
            System.out.format("%s, %s, %s, %s, %s, %d\n", code, name, continent, region, capital, population);
        }
        statement.close(); // close statement
    }

    public void query2(String continent) throws SQLException {
        // All the countries in a continent organised by largest population to smallest.
        String queryString = "SELECT code, " + // build query
                "country.name, " +
                "continent, " +
                "region, " +
                "country.population, " +
                "city.name AS capital " +
                "FROM country " +
                "JOIN city ON country.capital = city.id " +
                "WHERE continent LIKE \"" + continent + "\" " +
                "ORDER BY country.population DESC;";

        Statement statement = connection.createStatement(); // make statement to execute query
        ResultSet resultSet = statement.executeQuery(queryString); // execute query

        while (resultSet.next()) { // print all results from query
            String code = resultSet.getString("code");
            String name = resultSet.getString("name");
            String resultContinent = resultSet.getString("continent");
            String region = resultSet.getString("region");
            Long population = resultSet.getLong("population");
            String capital = resultSet.getString("capital");

            // make string and print it
            System.out.format("%s, %s, %s, %s, %s, %d\n", code, name, resultContinent, region, capital, population);
        }
        statement.close(); // close statement
    }

    public void query3(String region) throws SQLException {
        // All the countries in a continent organised by largest population to smallest.
        String queryString = "SELECT code, " + // build query
                "country.name, " +
                "continent, " +
                "region, " +
                "country.population, " +
                "city.name AS capital " +
                "FROM country " +
                "JOIN city ON country.capital = city.id " +
                "WHERE region LIKE \"" + region + "\" " +
                "ORDER BY country.population DESC;";

        Statement statement = connection.createStatement(); // make statement to execute query
        ResultSet resultSet = statement.executeQuery(queryString); // execute query

        while (resultSet.next()) { // print all results from query
            String code = resultSet.getString("code");
            String name = resultSet.getString("name");
            String continent = resultSet.getString("continent");
            String resultRegion = resultSet.getString("region");
            Long population = resultSet.getLong("population");
            String capital = resultSet.getString("capital");

            // make string and print it
            System.out.format("%s, %s, %s, %s, %s, %d\n", code, name, continent, resultRegion, capital, population);
        }
        statement.close(); // close statement
    }

    public void query4(int n) throws SQLException {
        // The top N populated countries in the world where N is provided by the user.
        String queryString = "SELECT code, " + // build query
                "country.name, " +
                "continent, " +
                "region, " +
                "country.population, " +
                "city.name AS capital " +
                "FROM country " +
                "JOIN city ON country.capital = city.id " +
                "ORDER BY country.population DESC " +
                "LIMIT " + n;

        Statement statement = connection.createStatement(); // make statement to execute query
        ResultSet resultSet = statement.executeQuery(queryString); // execute query

        while (resultSet.next()) { // print all results from query
            String code = resultSet.getString("code");
            String name = resultSet.getString("name");
            String continent = resultSet.getString("continent");
            String resultRegion = resultSet.getString("region");
            Long population = resultSet.getLong("population");
            String capital = resultSet.getString("capital");

            // make string and print it
            System.out.format("%s, %s, %s, %s, %s, %d\n", code, name, continent, resultRegion, capital, population);
        }
        statement.close(); // close statement
    }

    public void query5(int n, String continent) throws SQLException {
        // The top N populated countries in a continent where N is provided by the user.
        String queryString = "SELECT code, " + // build query
                "country.name, " +
                "continent, " +
                "region, " +
                "country.population, " +
                "city.name AS capital " +
                "FROM country " +
                "JOIN city ON country.capital = city.id " +
                "WHERE continent LIKE \"" + continent + "\" " +
                "ORDER BY country.population DESC " +
                "LIMIT " + n;

        Statement statement = connection.createStatement(); // make statement to execute query
        ResultSet resultSet = statement.executeQuery(queryString); // execute query

        while (resultSet.next()) { // print all results from query
            String code = resultSet.getString("code");
            String name = resultSet.getString("name");
            String resultContinent = resultSet.getString("continent");
            String region = resultSet.getString("region");
            Long population = resultSet.getLong("population");
            String capital = resultSet.getString("capital");

            // make string and print it
            System.out.format("%s, %s, %s, %s, %s, %d\n", code, name, resultContinent, region, capital, population);
        }
        statement.close(); // close statement
    }

    public void query6(int n, String region) throws SQLException {
        // The top N populated countries in a region where N is provided by the user.
        String queryString = "SELECT code, " + // build query
                "country.name, " +
                "continent, " +
                "region, " +
                "country.population, " +
                "city.name AS capital " +
                "FROM country " +
                "JOIN city ON country.capital = city.id " +
                "WHERE region LIKE \"" + region + "\" " +
                "ORDER BY country.population DESC " +
                "LIMIT " + n;

        Statement statement = connection.createStatement(); // make statement to execute query
        ResultSet resultSet = statement.executeQuery(queryString); // execute query

        while (resultSet.next()) { // print all results from query
            String code = resultSet.getString("code");
            String name = resultSet.getString("name");
            String continent = resultSet.getString("continent");
            String resultRegion = resultSet.getString("region");
            Long population = resultSet.getLong("population");
            String capital = resultSet.getString("capital");

            // make string and print it
            System.out.format("%s, %s, %s, %s, %s, %d\n", code, name, continent, resultRegion, capital, population);
        }
        statement.close(); // close statement
    }

    public void query7() throws SQLException {
        // All the cities in the world organised by largest population to smallest.
        String queryString = "SELECT city.name, " + // build query
                "country.name, " +
                "district, " +
                "city.population " +
                "FROM city " +
                "JOIN country ON city.countrycode = country.code " +
                "ORDER BY city.population DESC;";

        Statement statement = connection.createStatement(); // make statement to execute query
        ResultSet resultSet = statement.executeQuery(queryString); // execute query

        System.out.println("name, country, district, population");
        while (resultSet.next()) { // print all results from query
            String name = resultSet.getString("city.name");
            String country = resultSet.getString("country.name");
            String district = resultSet.getString("district");
            Long population = resultSet.getLong("city.population");

            // make city report string and print it
            System.out.format("%s, %s, %s, %d\n", name, country, district, population);
        }
        statement.close(); // close statement
    }

    public void query8(String continent) throws SQLException {
        // All the cities in a continent organised by largest population to smallest.
        String queryString = "SELECT city.name, " + // build query
                "country.name, " +
                "district, " +
                "city.population " +
                "FROM city " +
                "JOIN country ON city.countrycode = country.code " +
                "WHERE continent LIKE \"" + continent + "\" " +
                "ORDER BY city.population DESC;";

        Statement statement = connection.createStatement(); // make statement to execute query
        ResultSet resultSet = statement.executeQuery(queryString); // execute query

        System.out.println("name, country, district, population");
        while (resultSet.next()) { // print all results from query
            String name = resultSet.getString("city.name");
            String country = resultSet.getString("country.name");
            String district = resultSet.getString("district");
            Long population = resultSet.getLong("city.population");

            // make city report string and print it
            System.out.format("%s, %s, %s, %d\n", name, country, district, population);
        }
        statement.close(); // close statement
    }

    public void query9(String region) throws SQLException {
        // All the cities in a region organised by largest population to smallest.
        String queryString = "SELECT city.name, " + // build query
                "country.name, " +
                "district, " +
                "city.population " +
                "FROM city " +
                "JOIN country ON city.countrycode = country.code " +
                "WHERE region LIKE \"" + region + "\" " +
                "ORDER BY city.population DESC;";

        Statement statement = connection.createStatement(); // make statement to execute query
        ResultSet resultSet = statement.executeQuery(queryString); // execute query

        System.out.println("name, country, district, population");
        while (resultSet.next()) { // print all results from query
            String name = resultSet.getString("city.name");
            String country = resultSet.getString("country.name");
            String district = resultSet.getString("district");
            Long population = resultSet.getLong("city.population");

            // make city report string and print it
            System.out.format("%s, %s, %s, %d\n", name, country, district, population);
        }
        statement.close(); // close statement
    }

    public void query10(String country) throws SQLException {
        // All the cities in a country organised by largest population to smallest.
        String queryString = "SELECT city.name, " + // build query
                "country.name, " +
                "district, " +
                "city.population " +
                "FROM city " +
                "JOIN country ON city.countrycode = country.code " +
                "WHERE country.name LIKE \"" + country + "\" " +
                "ORDER BY city.population DESC;";

        Statement statement = connection.createStatement(); // make statement to execute query
        ResultSet resultSet = statement.executeQuery(queryString); // execute query

        System.out.println("name, country, district, population");
        while (resultSet.next()) { // print all results from query
            String name = resultSet.getString("city.name");
            String resultCountry = resultSet.getString("country.name");
            String district = resultSet.getString("district");
            Long population = resultSet.getLong("city.population");

            // make city report string and print it
            System.out.format("%s, %s, %s, %d\n", name, resultCountry, district, population);
        }
        statement.close(); // close statement
    }

    public void query11(String district) throws SQLException {
        // All the cities in a district organised by largest population to smallest.
        String queryString = "SELECT city.name, " + // build query
                "country.name, " +
                "district, " +
                "city.population " +
                "FROM city " +
                "JOIN country ON city.countrycode = country.code " +
                "WHERE district LIKE \"" + district + "\" " +
                "ORDER BY city.population DESC;";

        Statement statement = connection.createStatement(); // make statement to execute query
        ResultSet resultSet = statement.executeQuery(queryString); // execute query

        System.out.println("name, country, district, population");
        while (resultSet.next()) { // print all results from query
            String name = resultSet.getString("city.name");
            String country = resultSet.getString("country.name");
            String resultDistrict = resultSet.getString("district");
            Long population = resultSet.getLong("city.population");

            // make city report string and print it
            System.out.format("%s, %s, %s, %d\n", name, country, resultDistrict, population);
        }
        statement.close(); // close statement
    }
}
