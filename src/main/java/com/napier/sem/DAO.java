package com.napier.sem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private final Connection connection;
    public DAO(Connection connection) {this.connection = connection; }


    public ArrayList<String> AllCountries(){
        String queryString = "select code, " +
                "country.name, " +
                "continent, " +
                "region," +
                " country.population, " +
                "city.name AS capital " +
                "FROM country " +
                "JOIN city ON country.capital = city.id " +
                "WHERE country.code LIKE '%' " +
                "ORDER BY country.population DESC";
        ArrayList<String> records = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryString);
// Create Country object and add it to the list for each result in the query
            while (resultSet.next())
            {
                if (resultSet.getString("name") != null) records.add(new String(String.valueOf(resultSet)));
            }
        }
        catch (SQLException e)
        {
//            System.out.println(recordType + " query failed");
            System.out.println(e.getMessage());
            return null;
        }
        return records;
    }

    public void firstQuery() throws SQLException
    {
        String queryString = "select code, " +
                "country.name, " +
                "continent, " +
                "region," +
                " country.population, " +
                "city.name AS capital " +
                "FROM country " +
                "JOIN city ON country.capital = city.id " +
                "WHERE country.code LIKE '%' " +
                "ORDER BY country.population DESC " +
                "LIMIT 5";

        Statement st = connection.createStatement();

        ResultSet resultSet = st.executeQuery(queryString);

        while(resultSet.next())
        {
            String code = resultSet.getString("code");
            String name = resultSet.getString("name");
            String continent = resultSet.getString("continent");
            String region = resultSet.getString("region");
            Long population = resultSet.getLong("population");
            String capital = resultSet.getString("capital");

            System.out.format("%s, %s, %s, %s, %s, %s\n", code, name, continent, region, population, capital);
//            System.out.format("%s \n", code);
            System.out.println();
        }
        st.close();
    }
}
